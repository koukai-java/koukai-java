# ベースイメージとして Tomcat を使用します
FROM tomcat:latest

# 作業ディレクトリを設定します
WORKDIR /usr/local/tomcat/webapps

# アプリケーションのソースコードをコンテナにコピーします
COPY . /app

# コンテナ内でアプリケーションをビルドします (例: Ant を使用する場合)
# RUN apt-get update && apt-get install -y ant
# RUN ant

# コンテナ内でアプリケーションをビルドします (例: Gradle を使用する場合)
# RUN apt-get update && apt-get install -y gradle
# RUN gradle build

# コンテナ内でアプリケーションをコンパイルし、WAR ファイルを作成します (手動コンパイルの場合)
RUN javac /app/src/main/java/**/*.java -d /app/build/classes
RUN mkdir -p /app/build/ROOT
COPY /app/webapp /app/build/ROOT
RUN jar -cvf ROOT.war -C /app/build/ROOT .

# WAR ファイルを Tomcat の webapps ディレクトリにコピーします
COPY ROOT.war /usr/local/tomcat/webapps/ROOT.war

# ポートを公開します
EXPOSE 8080

