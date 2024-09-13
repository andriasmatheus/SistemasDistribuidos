#---------------------------- EXECUÇÃO --------------------------------
if [ -z "$1" ];then
	echo -e "\033[01;31m[!] Nenhum arquivo passado para compilação [!]\033[0m"
	exit 1
fi

if [[  ! $(dpkg -l astyle) ]]
then
	echo -e "\033[01;31m[!] Instalando dependencias... [!]\033[0m"
	sudo apt install -y astyle;
	echo " ********************** "
fi

echo -e "\033[01;31m[!] Começando o processo de compilação... [!]\033[0m"
javac *.java
java Main "$1"
if [ $? -ne 0 ];
then
	echo -e "\033[01;31m[!] Erro na Compilação... [!]\033[0m"
	exit 1
else
	astyle --quiet output.c
	gcc output.c
	./a.out
	exit 0
fi