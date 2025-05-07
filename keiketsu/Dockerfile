# ベースイメージとして Tomcat を使用します
FROM tomcat:latest

# 作業ディレクトリを設定します
WORKDIR /usr/local/tomcat/webapps

# アプリケーションのソースコードをコンテナにコピーします
COPY app/ /app/

# アプリケーションをビルドし、WAR ファイルを作成します
RUN cd /app && \
    javac -d build/classes src/**/*.java && \
    /usr/local/tomcat/bin/jspc -d build/classes -webapp /app/src/main/webapp /app/src/main/webapp/**/*.jsp && \
    jar -cvf ROOT.war -C build/classes . && \
    cp ROOT.war /usr/local/tomcat/webapps/

# ポートを公開します
EXPOSE 8080

# Tomcat を起動します
CMD ["catalina.sh", "run"]
