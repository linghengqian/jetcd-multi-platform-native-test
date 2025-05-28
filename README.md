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
./mvnw -PnativeTestInCustom -e -T 1C clean test
```

- Generate GRM by changing the POM and executing `./mvnw -PgenerateMetadata -e -T 1C clean test native:metadata-copy`.

- Another idea is to use `-XX:MissingRegistrationReportingMode=Warn`.
```shell
vfox add java
vfox install java@24.0.1-graalce
vfox use --global java@24.0.1-graalce

git clone git@github.com:linghengqian/jetcd-multi-platform-native-test.git
cd ./jetcd-multi-platform-native-test/
./mvnw -PnativeTestBtwThrowMissingRegistrationErrors -e -T 1C clean test
.\target\native-tests.exe --xml-output-dir .\target\native-test-reports "-Djunit.platform.listeners.uid.tracking.output.dir=.\target\test-ids" -XX:MissingRegistrationReportingMode=Warn
```

- The log is as follows.

```shell
PS D:\TwinklingLiftWorks\git\public\jetcd-multi-platform-native-test> ./mvnw -PnativeTestInCustom -e -T 1C clean test
WARNING: A restricted method in java.lang.System has been called
WARNING: java.lang.System::load has been called by org.fusesource.jansi.internal.JansiLoader in an unnamed module (file:/C:/Users/lingh/.m2/wrapper/dists/apache-maven-3.9.9/977a63e90f436cd6ade95b4c0e10c20c/lib/jansi-2.4.1.jar)
WARNING: Use --enable-native-access=ALL-UNNAMED to avoid a warning for callers in this module
WARNING: Restricted methods will be blocked in a future release unless native access is enabled

WARNING: A terminally deprecated method in sun.misc.Unsafe has been called
WARNING: sun.misc.Unsafe::objectFieldOffset has been called by com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper (file:/C:/Users/lingh/.m2/wrapper/dists/apache-maven-3.9.9/977a63e90f436cd6ade95b4c0e10c20c/lib/guava-33.2.1-jre.jar)
WARNING: Please consider reporting this to the maintainers of class com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper
WARNING: sun.misc.Unsafe::objectFieldOffset will be removed in a future release
[INFO] Error stacktraces are turned on.
[INFO] Scanning for projects...
[INFO] 
[INFO] Using the MultiThreadedBuilder implementation with a thread count of 16
[INFO]
[INFO] ------< com.github.linghengqian:jetcd-multi-platform-native-test >------
[INFO] Building jetcd-multi-platform-native-test 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ jetcd-multi-platform-native-test ---
[INFO] Deleting D:\TwinklingLiftWorks\git\public\jetcd-multi-platform-native-test\target
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ jetcd-multi-platform-native-test ---
[INFO] skip non existing resourceDirectory D:\TwinklingLiftWorks\git\public\jetcd-multi-platform-native-test\src\main\resources
[INFO]
[INFO] --- compiler:3.13.0:compile (default-compile) @ jetcd-multi-platform-native-test ---
[INFO] No sources to compile
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ jetcd-multi-platform-native-test ---
[INFO] Copying 14 resources from src\test\resources to target\test-classes
[INFO] 
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ jetcd-multi-platform-native-test ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 1 source file with javac [debug release 24] to target\test-classes
[INFO] 
[INFO] --- surefire:3.2.5:test (default-test) @ jetcd-multi-platform-native-test ---
[WARNING]  Parameter 'systemProperties' is deprecated: Use systemPropertyVariables instead.
[INFO] Surefire report directory: D:\TwinklingLiftWorks\git\public\jetcd-multi-platform-native-test\target\surefire-reports
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[main] INFO org.testcontainers.images.PullPolicy - Image pull policy will be performed by: DefaultPullPolicy()
[main] INFO org.testcontainers.utility.ImageNameSubstitutor - Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
[INFO] Running com.github.linghengqian.SimpleTest
[Thread-1] INFO org.testcontainers.DockerClientFactory - Testcontainers version: 1.21.0
[Thread-1] INFO org.testcontainers.dockerclient.DockerClientProviderStrategy - Loaded org.testcontainers.dockerclient.NpipeSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
[Thread-1] INFO org.testcontainers.dockerclient.DockerClientProviderStrategy - Found Docker environment with local Npipe socket (npipe:////./pipe/docker_engine)
[Thread-1] INFO org.testcontainers.DockerClientFactory - Docker host IP address is localhost
[Thread-1] INFO org.testcontainers.DockerClientFactory - Connected to docker: 
  Server Version: 26.1.5
  API Version: 1.45
  Operating System: Rancher Desktop WSL Distribution
  Total Memory: 15588 MB
[Thread-1] INFO tc.testcontainers/ryuk:0.11.0 - Creating container for image: testcontainers/ryuk:0.11.0
[Thread-1] INFO org.testcontainers.utility.RegistryAuthLocator - Credential helper/store (docker-credential-wincred) does not have credentials for https://index.docker.io/v1/
[Thread-1] INFO tc.testcontainers/ryuk:0.11.0 - Container testcontainers/ryuk:0.11.0 is starting: e400dec663fd64ee62650a462c1a53f255b19334194d4a69062ac68521210104
[Thread-1] INFO tc.testcontainers/ryuk:0.11.0 - Container testcontainers/ryuk:0.11.0 started in PT0.5931879S
[Thread-1] INFO org.testcontainers.utility.RyukResourceReaper - Ryuk started - will monitor and terminate Testcontainers containers on JVM exit
[Thread-1] INFO org.testcontainers.DockerClientFactory - Checking the system...
[Thread-1] INFO org.testcontainers.DockerClientFactory - ?? Docker server version should be at least 1.6.0
[Thread-1] INFO tc.gcr.io/etcd-development/etcd:v3.5.10 - Creating container for image: gcr.io/etcd-development/etcd:v3.5.10
[Thread-1] INFO org.testcontainers.utility.RegistryAuthLocator - Credential helper/store (docker-credential-wincred) does not have credentials for gcr.io
[Thread-1] INFO tc.gcr.io/etcd-development/etcd:v3.5.10 - Container gcr.io/etcd-development/etcd:v3.5.10 is starting: df956e747fa5c7ea6b81b02285d3e38a6cc8675e3955e0727e49840fe1660b0b
[Thread-1] INFO org.testcontainers.containers.wait.strategy.HttpWaitStrategy - /clever_tesla: Waiting for 60 seconds for URL: http://localhost:33036/health (where port 33036 maps to container port 2379)
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.467469Z","caller":"flags/flag.go:113","msg":"recognized and used environment variable","variable-name":"ETCD_LOG_LEVEL","variable-value":"info"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.468108Z","caller":"flags/flag.go:113","msg":"recognized and used environment variable","variable-name":"ETCD_LOGGER","variable-value":"zap"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"warn","ts":"2025-05-28T07:16:41.468409Z","caller":"embed/config.go:676","msg":"Running http and grpc server on single port. This is not recommended for production."}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.468463Z","caller":"etcdmain/etcd.go
:73","msg":"Running: ","args":["etcd","--name","etcd0","--advertise-client-urls","http://0.0.0.0:2379","--listen-client-urls","http://0.0.0.0:2379","--data-dir","/tmp/etcd-data"]}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"warn","ts":"2025-05-28T07:16:41.468573Z","caller":"embed/config.go:676","msg":"Running http and grpc server on single port. This is not recommended for production."}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.468653Z","caller":"embed/etcd.go:127","msg":"configuring peer listeners","listen-peer-urls":["http://localhost:2380"]}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.469456Z","caller":"embed/etcd.go:135","msg":"configuring client listeners","listen-client-urls":["http://0.0.0.0:2379"]}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.469756Z","caller":"embed/etcd.go:30
9","msg":"starting an etcd server","etcd-version":"3.5.10","git-sha":"0223ca52b","go-version":"go1.20.10","go-os":"linux","go-arch":"amd64","max-cpu-set":16,"max-cpu-av
ailable":16,"member-initialized":false,"name":"etcd0","data-dir":"/tmp/etcd-data","wal-dir":"","wal-dir-dedicated":"","member-dir":"/tmp/etcd-data/member","force-new-cl
uster":false,"heartbeat-interval":"100ms","election-timeout":"1s","initial-election-tick-advance":true,"snapshot-count":100000,"max-wals":5,"max-snapshots":5,"snapshot-
catchup-entries":5000,"initial-advertise-peer-urls":["http://localhost:2380"],"listen-peer-urls":["http://localhost:2380"],"advertise-client-urls":["http://0.0.0.0:2379
"],"listen-client-urls":["http://0.0.0.0:2379"],"listen-metrics-urls":[],"cors":["*"],"host-whitelist":["*"],"initial-cluster":"etcd0=http://localhost:2380","initial-cl
uster-state":"new","initial-cluster-token":"etcd-cluster","quota-backend-bytes":2147483648,"max-request-bytes":1572864,"max-concurrent-streams":4294967295,"pre-vote":tr
ue,"initial-corrupt-check":false,"corrupt-check-time-interval":"0s","compact-check-time-enabled":false,"compact-check-time-interval":"1m0s","auto-compaction-mode":"periodic","auto-compaction-retention":"0s","auto-compaction-interval":"0s","discovery-url":"","discovery-proxy":"","downgrade-check-interval":"5s"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.472682Z","caller":"etcdserver/backend.go:81","msg":"opened backend db","path":"/tmp/etcd-data/member/snap/db","took":"2.026698ms"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.476848Z","caller":"etcdserver/raft.go:495","msg":"starting local member","local-member-id":"8e9e05c52164694d","cluster-id":"cdf818194e3a8c32"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.476921Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d switched to configuration voters=()"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.476945Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d became follower at term 0"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.476952Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"newRaft 8e9e05c52164694d [peers: [], term: 0, commit: 0, applied: 0, lastindex: 0, lastterm: 0]"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.476957Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d became follower at term 1"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.47698Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d switched to configuration voters=(10276657743932975437)"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"warn","ts":"2025-05-28T07:16:41.481269Z","caller":"auth/store.go:1241","msg":"simple token is not cryptographically signed"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.483143Z","caller":"mvcc/kvstore.go:407","msg":"kvstore restored","current-rev":1}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.484568Z","caller":"etcdserver/quota.go:94","msg":"enabled backend quota with default value","quota-name":"v3-applier","quota-size-bytes":2147483648,"quota-size":"2.1 GB"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.48608Z","caller":"etcdserver/server.go:854","msg":"starting etcd server","local-member-id":"8e9e05c52164694d","local-server-version":"3.5.10","cluster-version":"to_be_decided"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.486196Z","caller":"fileutil/purge.go:44","msg":"started to purge file","dir":"/tmp/etcd-data/member/snap","suffix":"snap.db","max":5,"interval":"30s"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.48627Z","caller":"fileutil/purge.go:44","msg":"started to purge file","dir":"/tmp/etcd-data/member/snap","suffix":"snap","max":5,"interval":"30s"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.486279Z","caller":"fileutil/purge.go:44","msg":"started to purge file","dir":"/tmp/etcd-data/member/wal","suffix":"wal","max":5,"interval":"30s"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.486314Z","caller":"etcdserver/serve
r.go:738","msg":"started as single-node; fast-forwarding election ticks","local-member-id":"8e9e05c52164694d","forward-ticks":9,"forward-duration":"900ms","election-ticks":10,"election-timeout":"1s"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.487892Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d switched to configuration voters=(10276657743932975437)"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.488047Z","caller":"membership/clust
er.go:421","msg":"added member","cluster-id":"cdf818194e3a8c32","local-member-id":"8e9e05c52164694d","added-peer-id":"8e9e05c52164694d","added-peer-peer-urls":["http://localhost:2380"]}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.488098Z","caller":"embed/etcd.go:27
8","msg":"now serving peer/client/metrics","local-member-id":"8e9e05c52164694d","initial-advertise-peer-urls":["http://localhost:2380"],"listen-peer-urls":["http://localhost:2380"],"advertise-client-urls":["http://0.0.0.0:2379"],"listen-client-urls":["http://0.0.0.0:2379"],"listen-metrics-urls":[]}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.488145Z","caller":"embed/etcd.go:597","msg":"serving peer traffic","address":"127.0.0.1:2380"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:41.488159Z","caller":"embed/etcd.go:569","msg":"cmux::serve","address":"127.0.0.1:2380"}
[Thread-1] INFO tc.gcr.io/etcd-development/etcd:v3.5.10 - Container gcr.io/etcd-development/etcd:v3.5.10 started in PT1.1331327S
WARNING: A terminally deprecated method in sun.misc.Unsafe has been called
WARNING: sun.misc.Unsafe::objectFieldOffset has been called by io.netty.util.internal.PlatformDependent0$4 (file:/C:/Users/lingh/.m2/repository/io/netty/netty-common/4.1.100.Final/netty-common-4.1.100.Final.jar)
WARNING: Please consider reporting this to the maintainers of class io.netty.util.internal.PlatformDependent0$4
WARNING: sun.misc.Unsafe::objectFieldOffset will be removed in a future release
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.077985Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d is starting a new election at term 1"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.078054Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d became pre-candidate at term 1"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.078102Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d received MsgPreVoteResp from 8e9e05c52164694d at term 1"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.078118Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d became candidate at term 2"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.078125Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d received MsgVoteResp from 8e9e05c52164694d at term 2"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.078134Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d became leader at term 2"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.078142Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"raft.node: 8e9e05c52164694d elected leader 8e9e05c52164694d at term 2"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.083661Z","caller":"etcdserver/serve
r.go:2062","msg":"published local member to cluster through raft","local-member-id":"8e9e05c52164694d","local-member-attributes":"{Name:etcd0 ClientURLs:[http://0.0.0.0:2379]}","request-path":"/0/members/8e9e05c52164694d/attributes","cluster-id":"cdf818194e3a8c32","publish-timeout":"7s"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.083753Z","caller":"embed/serve.go:103","msg":"ready to serve client requests"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.08377Z","caller":"etcdserver/server.go:2571","msg":"setting up initial cluster version using v2 API","cluster-version":"3.5"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.084118Z","caller":"etcdmain/main.go:44","msg":"notifying init daemon"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.084163Z","caller":"etcdmain/main.go:50","msg":"successfully notified init daemon"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.084896Z","caller":"membership/cluster.go:584","msg":"set initial cluster version","cluster-id":"cdf818194e3a8c32","local-member-id":"8e9e05c52164694d","cluster-version":"3.5"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.084996Z","caller":"api/capability.go:75","msg":"enabled capabilities for version","cluster-version":"3.5"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.085092Z","caller":"etcdserver/server.go:2595","msg":"cluster version is updated","cluster-version":"3.5"}
[docker-java-stream--86244608] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:16:42.085104Z","caller":"embed/serve.go:187","msg":"serving client traffic insecurely; this is strongly discouraged!","traffic":"grpc+http","address":"[::]:2379"}
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.294 s -- in com.github.linghengqian.SimpleTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- native:0.10.6:test (test-native) @ jetcd-multi-platform-native-test ---
[INFO] ====================
[INFO] Initializing project: jetcd-multi-platform-native-test
[INFO] ====================
[INFO] Found GraalVM installation from GRAALVM_HOME variable.
[INFO] Downloaded GraalVM reachability metadata repository from file:/C:/Users/lingh/.m2/repository/org/graalvm/buildtools/graalvm-reachability-metadata/0.10.6/graalvm-reachability-metadata-0.10.6-repository.zip
[INFO] [graalvm reachability metadata repository for io.netty:netty-resolver-dns:4.1.103.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-resolver-dns:4.1.103.Final]: Configuration directory is io.netty\netty-resolver-dns\4.1.80.Final    
[INFO] [graalvm reachability metadata repository for org.apache.commons:commons-compress:1.25.0]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for org.apache.commons:commons-compress:1.25.0]: Configuration directory is org.apache.commons\commons-compress\1.23.0 
[INFO] [graalvm reachability metadata repository for io.grpc:grpc-core:1.60.0]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.grpc:grpc-core:1.60.0]: Configuration directory is io.grpc\grpc-core\1.69.0
[INFO] [graalvm reachability metadata repository for io.grpc:grpc-netty:1.60.0]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.grpc:grpc-netty:1.60.0]: Configuration directory is io.grpc\grpc-netty\1.51.0
[INFO] [graalvm reachability metadata repository for io.netty:netty-codec-http2:4.1.100.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-codec-http2:4.1.100.Final]: Configuration directory is io.netty\netty-codec-http2\4.1.80.Final      
[INFO] [graalvm reachability metadata repository for io.netty:netty-common:4.1.100.Final]: Configuration directory is io.netty\netty-common\4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-buffer:4.1.100.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-buffer:4.1.100.Final]: Configuration directory is io.netty\netty-buffer\4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-transport:4.1.100.Final]: Configuration directory is io.netty\netty-transport\4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-handler:4.1.100.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-handler:4.1.100.Final]: Configuration directory is io.netty\netty-handler\4.1.80.Final
[INFO] [graalvm reachability metadata repository for io.netty:netty-codec-http:4.1.100.Final]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for io.netty:netty-codec-http:4.1.100.Final]: Configuration directory is io.netty\netty-codec-http\4.1.80.Final        
[INFO] [graalvm reachability metadata repository for com.google.protobuf:protobuf-java-util:3.24.0]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for com.google.protobuf:protobuf-java-util:3.24.0]: Configuration directory is com.google.protobuf\protobuf-java-util\3.21.12
[INFO] [graalvm reachability metadata repository for org.testcontainers:testcontainers:1.21.0]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for org.testcontainers:testcontainers:1.21.0]: Configuration directory is org.testcontainers\testcontainers\1.19.8     
[INFO] [graalvm reachability metadata repository for net.java.dev.jna:jna:5.13.0]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for net.java.dev.jna:jna:5.13.0]: Configuration directory is net.java.dev.jna\jna\5.8.0
[INFO] Executing: C:\Users\lingh\.version-fox\temp\1748361600-5184\java\bin\native-image.cmd @target\tmp\native-image-4959038573007182864.args org.graalvm.junit.platform.NativeImageJUnitLauncher
========================================================================================================================
GraalVM Native Image: Generating 'native-tests.exe' (executable)...
========================================================================================================================
For detailed information and explanations on the build output, visit:
https://github.com/oracle/graal/blob/master/docs/reference-manual/native-image/BuildOutput.md
------------------------------------------------------------------------------------------------------------------------
[1/8] Initializing...                                                                                   (13.1s @ 0.29GB)
 Java version: 24.0.1+9, vendor version: GraalVM CE 24.0.1+9.1
 Graal compiler: optimization level: b, target machine: x86-64-v3
 C compiler: cl.exe (microsoft, x64, 19.44.35207)
 Garbage collector: Serial GC (max heap size: 80% of RAM)
 2 user-specific feature(s):
 - com.oracle.svm.thirdparty.gson.GsonFeature
 - org.graalvm.junit.platform.JUnitPlatformFeature
------------------------------------------------------------------------------------------------------------------------
Build resources:
 - 13.25GB of memory (42.5% of 31.19GB system memory, determined at start)
 - 16 thread(s) (100.0% of 16 available processor(s), determined at start)
[junit-platform-native] Running in 'test listener' mode using files matching pattern [junit-platform-unique-ids*] found in folder [D:\TwinklingLiftWorks\git\public\jetcd-multi-platform-native-test\target\test-ids] and its subfolders.
[2/8] Performing analysis...  [*****]                                                                   (13.5s @ 2.34GB)
   16,881 reachable types   (85.8% of   19,668 total)
   29,273 reachable fields  (58.7% of   49,833 total)
   88,695 reachable methods (57.0% of  155,539 total)
    5,914 types,   311 fields, and 1,318 methods registered for reflection
      112 types,    92 fields, and   117 methods registered for JNI access
        5 native libraries: crypt32, ncrypt, psapi, version, winhttp
[3/8] Building universe...                                                                               (3.5s @ 2.03GB)
[4/8] Parsing methods...      [*]                                                                        (1.9s @ 1.19GB)
[5/8] Inlining methods...     [***]                                                                      (1.0s @ 1.68GB)
[6/8] Compiling methods...    [***]                                                                      (8.9s @ 1.70GB)
[7/8] Laying out methods...   [***]                                                                      (8.6s @ 2.15GB)
[8/8] Creating image...       [**]                                                                       (4.2s @ 2.51GB)
  38.92MB (50.27%) for code area:    55,916 compilation units
  36.94MB (47.71%) for image heap:  387,119 objects and 250 resources
   1.56MB ( 2.01%) for other data
  77.41MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 origins of code area:                                Top 10 object types in image heap:
  15.10MB java.base                                           11.11MB byte[] for code metadata
   5.09MB testcontainers-1.21.0.jar                            5.49MB byte[] for java.lang.String
   3.93MB java.xml                                             4.17MB java.lang.Class
   2.11MB svm.jar (Native Image)                               3.65MB java.lang.String
   1.58MB protobuf-java-3.24.0.jar                             1.42MB com.oracle.svm.core.hub.DynamicHubCompanion
 846.82kB docker-java-transport-zerodep-3.4.2.jar              1.16MB byte[] for reflection metadata
 738.00kB vertx-core-4.5.1.jar                                 1.12MB byte[] for embedded resources
 641.25kB grpc-core-1.60.0.jar                               876.00kB byte[] for general heap data
 609.51kB netty-common-4.1.100.Final.jar                     762.52kB java.lang.String[]
 556.21kB netty-buffer-4.1.100.Final.jar                     607.15kB c.o.svm.core.hub.DynamicHub$ReflectionMetadata
   7.39MB for 89 more packages                                 6.63MB for 3213 more object types
------------------------------------------------------------------------------------------------------------------------
Recommendations:
 HEAP: Set max heap for improved and more predictable memory usage.
 CPU:  Enable more CPU features with '-march=native' for improved performance.
------------------------------------------------------------------------------------------------------------------------
                        3.6s (6.3% of total time) in 328 GCs | Peak RSS: 3.55GB | CPU load: 7.73
------------------------------------------------------------------------------------------------------------------------
Build artifacts:
 D:\TwinklingLiftWorks\git\public\jetcd-multi-platform-native-test\target\native-tests.exe.exe (executable)
========================================================================================================================
Finished generating 'native-tests.exe' in 56.5s.
[INFO] Executing: D:\TwinklingLiftWorks\git\public\jetcd-multi-platform-native-test\target\native-tests.exe --xml-output-dir D:\TwinklingLiftWorks\git\public\jetcd-mult
i-platform-native-test\target\native-test-reports -Djunit.platform.listeners.uid.tracking.output.dir=D:\TwinklingLiftWorks\git\public\jetcd-multi-platform-native-test\target\test-ids
JUnit Platform on Native Image - report
----------------------------------------

[main] INFO org.testcontainers.images.PullPolicy - Image pull policy will be performed by: DefaultPullPolicy()
[main] INFO org.testcontainers.utility.ImageNameSubstitutor - Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
[Thread-0] INFO org.testcontainers.DockerClientFactory - Testcontainers version: 1.21.0
[Thread-0] INFO org.testcontainers.dockerclient.DockerClientProviderStrategy - Loaded org.testcontainers.dockerclient.NpipeSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
[Thread-0] INFO org.testcontainers.dockerclient.DockerClientProviderStrategy - Found Docker environment with local Npipe socket (npipe:////./pipe/docker_engine)
[Thread-0] INFO org.testcontainers.DockerClientFactory - Docker host IP address is localhost
[Thread-0] INFO org.testcontainers.DockerClientFactory - Connected to docker:
  Server Version: 26.1.5
  API Version: 1.45
  Operating System: Rancher Desktop WSL Distribution
  Total Memory: 15588 MB
[Thread-0] INFO tc.testcontainers/ryuk:0.11.0 - Creating container for image: testcontainers/ryuk:0.11.0
[Thread-0] INFO org.testcontainers.utility.RegistryAuthLocator - Credential helper/store (docker-credential-wincred) does not have credentials for https://index.docker.io/v1/
[Thread-0] INFO tc.testcontainers/ryuk:0.11.0 - Container testcontainers/ryuk:0.11.0 is starting: 91ea0ff35020bc681a5ec02439a2291610cb01364edfbf5dae241cdbaf1f9598
[Thread-0] INFO tc.testcontainers/ryuk:0.11.0 - Container testcontainers/ryuk:0.11.0 started in PT0.482518S
[Thread-0] INFO org.testcontainers.utility.RyukResourceReaper - Ryuk started - will monitor and terminate Testcontainers containers on JVM exit
[Thread-0] INFO org.testcontainers.DockerClientFactory - Checking the system...
[Thread-0] INFO org.testcontainers.DockerClientFactory - 鉁旓笌 Docker server version should be at least 1.6.0
[Thread-0] INFO tc.gcr.io/etcd-development/etcd:v3.5.10 - Creating container for image: gcr.io/etcd-development/etcd:v3.5.10
[Thread-0] INFO org.testcontainers.utility.RegistryAuthLocator - Credential helper/store (docker-credential-wincred) does not have credentials for gcr.io
[Thread-0] INFO tc.gcr.io/etcd-development/etcd:v3.5.10 - Container gcr.io/etcd-development/etcd:v3.5.10 is starting: acc574c627b2ba6256923643273892af34809a1b4134e81b9676f753c127f6fb
[Thread-0] INFO org.testcontainers.containers.wait.strategy.HttpWaitStrategy - /relaxed_moore: Waiting for 60 seconds for URL: http://localhost:33039/health (where port 33039 maps to container port 2379)
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.628891Z","caller":"flags/flag.go:113","msg":"recognized and used environment variable","variable-name":"ETCD_LOG_LEVEL","variable-value":"info"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.62954Z","caller":"flags/flag.go:113","msg":"recognized and used environment variable","variable-name":"ETCD_LOGGER","variable-value":"zap"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"warn","ts":"2025-05-28T07:17:48.629693Z","caller":"embed/config.go:676","msg":"Running http and grpc server on single port. This is not recommended for production."}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.629758Z","caller":"etcdmain/etcd.go
:73","msg":"Running: ","args":["etcd","--name","etcd0","--advertise-client-urls","http://0.0.0.0:2379","--listen-client-urls","http://0.0.0.0:2379","--data-dir","/tmp/etcd-data"]}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"warn","ts":"2025-05-28T07:17:48.62986Z","caller":"embed/config.go:676","msg":"Running http and grpc server on single port. This is not recommended for production."}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.629913Z","caller":"embed/etcd.go:127","msg":"configuring peer listeners","listen-peer-urls":["http://localhost:2380"]}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.630621Z","caller":"embed/etcd.go:135","msg":"configuring client listeners","listen-client-urls":["http://0.0.0.0:2379"]}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.630876Z","caller":"embed/etcd.go:30
9","msg":"starting an etcd server","etcd-version":"3.5.10","git-sha":"0223ca52b","go-version":"go1.20.10","go-os":"linux","go-arch":"amd64","max-cpu-set":16,"max-cpu-av
ailable":16,"member-initialized":false,"name":"etcd0","data-dir":"/tmp/etcd-data","wal-dir":"","wal-dir-dedicated":"","member-dir":"/tmp/etcd-data/member","force-new-cl
uster":false,"heartbeat-interval":"100ms","election-timeout":"1s","initial-election-tick-advance":true,"snapshot-count":100000,"max-wals":5,"max-snapshots":5,"snapshot-
catchup-entries":5000,"initial-advertise-peer-urls":["http://localhost:2380"],"listen-peer-urls":["http://localhost:2380"],"advertise-client-urls":["http://0.0.0.0:2379
"],"listen-client-urls":["http://0.0.0.0:2379"],"listen-metrics-urls":[],"cors":["*"],"host-whitelist":["*"],"initial-cluster":"etcd0=http://localhost:2380","initial-cl
uster-state":"new","initial-cluster-token":"etcd-cluster","quota-backend-bytes":2147483648,"max-request-bytes":1572864,"max-concurrent-streams":4294967295,"pre-vote":tr
ue,"initial-corrupt-check":false,"corrupt-check-time-interval":"0s","compact-check-time-enabled":false,"compact-check-time-interval":"1m0s","auto-compaction-mode":"periodic","auto-compaction-retention":"0s","auto-compaction-interval":"0s","discovery-url":"","discovery-proxy":"","downgrade-check-interval":"5s"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.634571Z","caller":"etcdserver/backend.go:81","msg":"opened backend db","path":"/tmp/etcd-data/member/snap/db","took":"2.432802ms"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.640436Z","caller":"etcdserver/raft.go:495","msg":"starting local member","local-member-id":"8e9e05c52164694d","cluster-id":"cdf818194e3a8c32"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.640557Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d switched to configuration voters=()"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.640596Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d became follower at term 0"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.640605Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"newRaft 8e9e05c52164694d [peers: [], term: 0, commit: 0, applied: 0, lastindex: 0, lastterm: 0]"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.640612Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d became follower at term 1"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.640645Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d switched to configuration voters=(10276657743932975437)"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"warn","ts":"2025-05-28T07:17:48.647084Z","caller":"auth/store.go:1241","msg":"simple token is not cryptographically signed"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.649769Z","caller":"mvcc/kvstore.go:407","msg":"kvstore restored","current-rev":1}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.653089Z","caller":"etcdserver/quota.go:94","msg":"enabled backend quota with default value","quota-name":"v3-applier","quota-size-bytes":2147483648,"quota-size":"2.1 GB"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.6554Z","caller":"etcdserver/server.go:854","msg":"starting etcd server","local-member-id":"8e9e05c52164694d","local-server-version":"3.5.10","cluster-version":"to_be_decided"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.655651Z","caller":"etcdserver/serve
r.go:738","msg":"started as single-node; fast-forwarding election ticks","local-member-id":"8e9e05c52164694d","forward-ticks":9,"forward-duration":"900ms","election-ticks":10,"election-timeout":"1s"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.655726Z","caller":"fileutil/purge.go:44","msg":"started to purge file","dir":"/tmp/etcd-data/member/snap","suffix":"snap.db","max":5,"interval":"30s"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.655768Z","caller":"fileutil/purge.go:44","msg":"started to purge file","dir":"/tmp/etcd-data/member/snap","suffix":"snap","max":5,"interval":"30s"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.655782Z","caller":"fileutil/purge.go:44","msg":"started to purge file","dir":"/tmp/etcd-data/member/wal","suffix":"wal","max":5,"interval":"30s"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.657733Z","caller":"embed/etcd.go:27
8","msg":"now serving peer/client/metrics","local-member-id":"8e9e05c52164694d","initial-advertise-peer-urls":["http://localhost:2380"],"listen-peer-urls":["http://localhost:2380"],"advertise-client-urls":["http://0.0.0.0:2379"],"listen-client-urls":["http://0.0.0.0:2379"],"listen-metrics-urls":[]}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.657765Z","caller":"embed/etcd.go:597","msg":"serving peer traffic","address":"127.0.0.1:2380"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.657815Z","caller":"embed/etcd.go:569","msg":"cmux::serve","address":"127.0.0.1:2380"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.659101Z","logger":"raft","caller":"etcdserver/zap_raft.go:77","msg":"8e9e05c52164694d switched to configuration voters=(10276657743932975437)"}
[docker-java-stream-531091409] INFO io.etcd.jetcd.launcher.EtcdContainer - [etcd0] STDERR: {"level":"info","ts":"2025-05-28T07:17:48.659293Z","caller":"membership/clust
er.go:421","msg":"added member","cluster-id":"cdf818194e3a8c32","local-member-id":"8e9e05c52164694d","added-peer-id":"8e9e05c52164694d","added-peer-peer-urls":["http://localhost:2380"]}
[Thread-0] INFO tc.gcr.io/etcd-development/etcd:v3.5.10 - Container gcr.io/etcd-development/etcd:v3.5.10 started in PT0.748609S
WARNING: A terminally deprecated method in sun.misc.Unsafe has been called
WARNING: sun.misc.Unsafe::getLong has been called by io.netty.util.internal.PlatformDependent0$4 (file:/D:/TwinklingLiftWorks/git/public/jetcd-multi-platform-native-test/target/native-tests.exe.exe)
WARNING: Please consider reporting this to the maintainers of class io.netty.util.internal.PlatformDependent0$4
WARNING: sun.misc.Unsafe::getLong will be removed in a future release
[main] INFO io.vertx.core.spi.resolver.ResolverProvider - Using the default address resolver as the dns resolver could not be loaded
```