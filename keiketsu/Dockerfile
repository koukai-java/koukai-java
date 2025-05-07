FROM tomcat:latest

# アプリケーションの WAR ファイルを Tomcat の webapps ディレクトリにコピー
COPY target/*.war /usr/local/tomcat/webapps/

# 必要に応じて追加の設定（環境変数、ポートなど）
# ENV JAVA_OPTS="-Xmx512m -Xms256m"
# EXPOSE 8080
