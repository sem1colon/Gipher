cd accountmanager
source ./env-variable.sh
mvn clean package
cd ..
cd giphermanager
source ./env-variable.sh
mvn clean package
cd ..