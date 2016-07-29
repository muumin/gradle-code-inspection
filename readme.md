静的コード解析サンプル
=====================================

* checkstyle
* findbugs
* PMD
* PMD-CPD
* JaCoCo
* JDepend
* codenarc

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
