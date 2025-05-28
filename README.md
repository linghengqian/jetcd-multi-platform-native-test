# jetcd-multi-platform-native-test

- For https://github.com/apache/shardingsphere/issues/35052 .
- Execute the following PowerShell 7 command on the `Windows 11 Home 24H2` instance with `PowerShell/PowerShell`,
  `version-fox/vfox`, `git-for-windows/git`, `rancher-sandbox/rancher-desktop` and
  `Microsoft.VisualStudio.2022.Community` installed.

```shell
vfox add java
vfox install java@22.0.2-graalce
vfox use --global java@22.0.2-graalce

git clone git@github.com:linghengqian/jetcd-multi-platform-native-test.git
cd ./jetcd-multi-platform-native-test/
./mvnw -PgenerateMetadata -e -T 1C clean test native:metadata-copy
./mvnw -PnativeTestInCustom -e -T 1C clean test > ./log.txt
```

- The log is as follows.

```shell

```