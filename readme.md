静的コード解析サンプル
=====================================

* checkstyle
* findbugs
* PMD
* PMD-CPD
* JaCoCo
* JDepend
* codenarc
* SonarQube

以下のコマンドを実行するとbuild/reports配下に解析結果が出力される。

    gradlew

# checkstyle

コーディング規約をチェックするための静的解析ツール

## チェック回避

以下のコメントが使用可能

* 「//CHECKSTYLE IGNORE THIS LINE」で行単位で回避
* 「//CHECKSTYLE:OFF」から「//CHECKSTYLE:ON」まで複数行単位で回避

# findbugs

バイトコードとバグ・パターンリストを比較してプログラム内のエラーとなる可能性の高いコードを解析するツール

## チェック回避

config/findbugs_exlude_filter.xmlにてパッケージ単位/クラス名などで定義可能

## xmlで結果出力

enabled = falseに変更する

    tasks.withType(FindBugs) {
        reports {
            html {
                enabled = false
                destination = "${findbugs.reportsDir}/findbugs.html"
            }
            xml.enabled = !html.enabled
        }
    }

# PMD

潜在的なバグやコーディング規約をチェックすることができる静的解析ツール

## チェック回避

* 「//NOPMD」で行単位で回避
* config/pmd-ruleset.xmlにて定義可能

# PMD-CPD

重複コード検出ツール

# JaCoCo

コードカバレッジ計測ツール

# JDepend

Javaパッケージ単位のメトリクスを測定するツール

# CodeNarc

Groovy向けの静的コード解析ツール

config/codenarc.groovyでチェックするルールを追加可能

# SonarQube

## Docker起動

Dockerをインストールしたら Volume Data Container を作成する。

    docker volume create --name sonar_data
    docker volume create --name mysql_data

配置したら以下のコマンドで起動する。

    docker-compose up -d

停止する場合は以下

    docker-compose stop

## sonar実行

    % gradle clean build jacocoTestReport sonar

## Volume Data Containerのバックアップ

NAMESを調べる。

    % docker ps
    CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
    56f8000f844c        sonarqube:5.6       "./bin/run.sh"           5 minutes ago       Up 4 minutes        0.0.0.0:9000->9000/tcp   gradleinspectionsample_sonar_1
    d3b564b02064        mysql:5.7           "docker-entrypoint.sh"   5 minutes ago       Up 4 minutes        0.0.0.0:3306->3306/tcp   gradleinspectionsample_mysql_1

DockerのCPコマンドでNAMESを指定してコピーする。

    $ docker cp gradleinspectionsample_sonar_1:/opt/sonarqube/extensions .
    $ tar -cvf sonar.tar extensions
    $ rm -rf extensions
    $ docker cp gradleinspectionsample_mysql_1:/var/lib/mysql .
    $ tar -cvf mysql.tar mysql
    $ rm -rf mysql

