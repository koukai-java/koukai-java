# ベースイメージとして Tomcat を使用します
FROM tomcat:latest

# 作業ディレクトリを設定します (一時的なビルド用)
WORKDIR /app

# アプリケーションのソースコードをコンテナにコピーします
COPY keiketsu /app/

# アプリケーションをビルドし、WAR ファイルを作成します
RUN javac -d build/classes /app/src/main/java/**/*.java && \
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