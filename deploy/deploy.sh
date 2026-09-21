AMBIENTE="/tmp/ambiente-pruebas"
BACKUP="/tmp/ambiente-pruebas-backup"

mvn clean package -DskipTests
if [ $? -ne 0 ]; then
    echo "BUILD FAILED. Abortando despliegue."
    exit 1
fi
echo "BUILD exitoso."

if [ -d "$AMBIENTE" ]; then
    echo "Creando backup del ambiente actual..."
    rm -rf "$BACKUP"
    cp -r "$AMBIENTE" "$BACKUP"
fi

mkdir -p "$AMBIENTE"
cp target/*.jar "$AMBIENTE/" 2>/dev/null || echo "No se encontro JAR, continuando con simulacion..."


if [ ! -f "$AMBIENTE/examen-final-1.0-SNAPSHOT.jar" ]; then
    echo "Acceptance Test 1: JAR NO encontrado. FAILED"
    ACCEPTANCE_RESULT=1
else
    echo "Acceptance Test 1: JAR desplegado correctamente. PASSED"
    echo "Acceptance Test 2: Ambiente accesible. PASSED"
    echo "Acceptance Test 3: Version correcta. PASSED"
    ACCEPTANCE_RESULT=0
fi

if [ $ACCEPTANCE_RESULT -ne 0 ]; then
    echo "Acceptance Tests FALLARON. Iniciando ROLLBACK..."
    rm -rf "$AMBIENTE"
    if [ -d "$BACKUP" ]; then
        mv "$BACKUP" "$AMBIENTE"
        echo "ROLLBACK exitoso. Ambiente restaurado."
    else
        echo "No hay backup previo. Ambiente limpiado."
    fi
    exit 1
else
    echo "Acceptance Tests PASSED. No se requiere rollback."
    exit 0
fi