# jetcd-multi-platform-native-test

- For https://github.com/apache/shardingsphere/issues/35052 .
- Execute the following PowerShell 7 command on the `Windows 11 Home 24H2` instance with `PowerShell/PowerShell`,
  `version-fox/vfox`, `git-for-windows/git`, `rancher-sandbox/rancher-desktop` and
  `Microsoft.VisualStudio.2022.Community` installed.

```shell
vfox add java
vfox install java@24.0.1-graalce
vfox use --global java@24.0.1-graalce

git clone git@github.com:linghengqian/jetcd-multi-platform-native-test.git
cd ./jetcd-multi-platform-native-test/
./mvnw -PnativeTestInCustom -e -T 1C clean test > ./log.txt
.\target\native-tests.exe --xml-output-dir .\target\native-test-reports "-Djunit.platform.listeners.uid.tracking.output.dir=.\target\test-ids" -XX:MissingRegistrationReportingMode=Warn
```

- Generate GRM by changing the POM and executing `./mvnw -PgenerateMetadata -e -T 1C clean test native:metadata-copy`.
- The log is as follows.

```shell

```