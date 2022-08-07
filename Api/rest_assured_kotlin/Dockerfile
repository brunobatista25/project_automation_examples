FROM openjdk:11
# Atualizando o apt-get
# instalando o build-essential
# instalando o curl e o wget
# instalando o apt-utils
# instalando maven
# removendo lixo do apt-get
RUN apt-get update && \
    apt-get install build-essential -y && \
    apt-get install -y curl wget && \
    apt-get install apt-utils -y && \
    apt-get install maven -y && \
    apt-get -y clean

# copiando a pasta raiz
COPY . ./

CMD tail -f /dev/null