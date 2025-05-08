# ベースイメージとして Tomcat を使用します
FROM tomcat:latest

# 作業ディレクトリを設定します (一時的なビルド用)
WORKDIR /app

# アプリケーションのソースコードをコンテナにコピーします
COPY . /app/

# Tomcat の lib ディレクトリに移動してみる (間接的なアクセス確認)
RUN ls /usr/local/tomcat/lib

# Tomcat の lib ディレクトリから Servlet API の JAR ファイルをコピーします
COPY /usr/local/tomcat/lib/servlet-api.jar /app/servlet-api.jar

# アプリケーションをビルドし、WAR ファイルを作成します
RUN javac -classpath /app/servlet-api.jar -d build/classes /app/src/main/java/**/*.java && \
    /usr/local/tomcat/bin/jspc -d build/classes -webapp /app/src/main/webapp /app/src/main/webapp/**/*.jsp && \
    /usr/local/tomcat/bin/jspc -d build/classes -webapp /app/src/main/webapp /app/src/main/webapp/WEB-INF/jsp /app/src/main/webapp/WEB-INF/jsp/**/*.jsp && \
    jar -cvf ROOT.war -C build/classes . && \
    cp ROOT.war /usr/local/tomcat/webapps/ROOT.war

# 作業ディレクトリを Tomcat の webapps に変更 (実行時)
WORKDIR /usr/local/tomcat/webapps

# ポートを公開します
EXPOSE 8080

# Tomcat を起動します
CMD ["catalina.sh", "run"]