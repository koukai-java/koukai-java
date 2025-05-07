# ビルドステージ（MavenでWARを作成）
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# 実行ステージ（TomcatでWARをデプロイ）
FROM tomcat:9.0
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/

# ポートなどの追加設定（必要に応じて）
# ENV JAVA_OPTS="-Xmx512m -Xms256m"
EXPOSE 8080
