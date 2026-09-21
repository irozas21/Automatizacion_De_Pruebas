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

echo "Acceptance Test 1: Verificando conexion a base de datos... FAILED"
echo "ERROR: No se pudo conectar a la base de datos de pruebas"
ACCEPTANCE_RESULT=1

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