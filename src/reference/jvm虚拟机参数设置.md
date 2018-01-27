## 堆分配参数总结
- **-Xmx:** 最大堆大小
- **-Xms:** 应用程序启动时初始堆大小
- **-Xmn:** 新生代大小，新生代大小一般为整个堆空间的1/4到1/3左右(等同于设置了相同的-XX:NewSize和-XX:MaxNewSize)
- **-XX:MinHeapFreeRatio:** 设置堆空间最小空闲比例。当堆空间的空闲内存小于这个数值时，JVM便会扩展堆空间
- **-XX:MaxHeapFreeRatio:** 设置堆空间的最大空闲比例。但堆空间的空闲内存大于这个数值时，便会压缩堆空间，得到一个较小的堆
- **-XX:NewSize:** 用于设置新生代的初始大小
- **-XX:MaxNewSize:** 设置新生代的最大值
- **-XX:NewRatio:** 设置老年代与新生代的比例，等于老年代大小除以新生代大小
- **-XX:PermSize:** 设置永久区的初始值
- **-XX:MaxPermSize:** 设置最大的永久区大小，一般为64MB，最大为128MB
- **-Xss:** 设置线程栈大小
- **XX:MaxDirectMemorySize:** 本机直接内存(DirectMemory容量)，若不指定，则与java堆最大值(-Xmx)一样
- **-XX:TargetSurvivorRatio:** 设置survivor区的可使用率。当survivor区的空间使用率达到这个数值时，会将对象送入老年代。

## GC相关参数总结
### 与串行回收器相关的参数
- **-XX:+UseSerialGC:** 在新生代和老年代使用串行收集器
- **-XX:SurvivorRatio:** 设置eden区大小和survivor区大小的比例(例SurvivorRatio为2，eden/s0=2)
- **-XX:NewRatio:** 用来设置新生代和老年代的比例(-XX:NewRatio=老年代/新生代)
- **-XX:PretenureSizeThreshold:** 设置大对象直接进入老年带的阀值。当对象的大小超过这个值时，将直接在老年代分配
- **-XX:MaxTenuringThreshold:** 设置对象对入老年代的年龄的最大值。每一次Minor GC后，对象年龄就加1.任何大于这个年龄的对象，一定会进入老年代

### 与并行GC相关的参数
- **-XX:+UseParNewGC:** 在新生代使用并行收集器,老年代使用串行收集器
- **-XX:+UseParallelGC:** 新生代使用并行回收收集器，老年代使用串行收集器
- **-XX:+UseParallelOldGC:** 新生代和老年代都使用并行回收收集器
- **-XX:ParallelGCThreads:** 设置用于垃圾回收的线程数
- **-XX:MaxGCPauseMillis:** 设置最大垃圾收集停顿时间。其值是一个大于0的证书。收集器在工作时，会调整java堆大小或者其他一些参数，尽可能地把停顿时间控制在MaxGCPauseMillis以内
- **-XX:GCTimeRatio:** 设置吞吐量大小，值是一个0～100之间的整数。假设GCTimeRatio的值为n，那么系统将花费不超过1/(1+n)的时间用于垃圾收集
- **-XX:UseAdaptiveSizePolicy:** 打开自适应GC策略。在这种模式下，新生代的大小、eden和survivor的比例、晋升老年代的对象年龄等参数会被自动调整，以达到在堆大小、吞吐量和停顿时间之间的平衡点

### 与CMS回收器相关的参数
- **-XX:+UseConcMarkSweepGC:** 新生代使用并行收集器，老年代使用CMS+串行收集器
- **-XX:ParallelCMSThread:** 设定CMS的线程数量
- **-XX:CMSInitiatingOccupancyFraction:** 设置CMS收集器在老年代空间被使用多少后触发。默认为68%
- **-XX:+UseCMSCompactAtFullCollection:** 设置CMS收集器在完成垃圾收集后是否要进行一次内存碎片的整理
- **-XX:CMSFullGCsBeforeCompaction:** 设定进行多少次CMS垃圾回收后，进行一次内存压缩
- **-XX:+CMSClassUnloadingEnabled:** 允许对类元数据进行回收
- **-XX:+CMSParallelRemarkEnabled:** 启用并行重标记
- **-XX:CMSInitiatingPermOccupancyFraction:** 当永久区占用率达到这一百分比时，启动CMS回收(前提是-XX:+CMSClassUnloadingEnabled激活了)
- **-XX:UseCMSInitiatingOccupancyOnly:** 表示只用在到达阀值的时候，才进行CMS回收
- **-XX:+CMSIncrementalMode:** 使用增量模式，比较适合单CPU

### 与G1回收器相关的参数
- **-XX:+UseG1GC:** 使用G1回收器
- **-XX:+UnlockExperimentalVMOptions:** 允许使用实验性参数
- **-XX:MaxGCPauseMillis:** 设置最大垃圾收集停顿时间
- **-XX:GCPauseIntervalMillis:** 设置停顿间隔时间

### 其他参数
- **-XX:+DisableExplicitGC:** 禁用显示GC(即System.gc()不触发Full GC)
- **-verbose:gc或-XX:+PrintGC:** 获取一段简要的GC信息
- **-XX:+PrintGCDetails:** 获取详细的GC信息
- **-Xverify:none:** 禁用class校验
- **-Xnoclassgc** 禁用类元数据回收


## 垃圾收集器的分类
- 按**线程数**分，可以分为**串行垃圾回收器**和**并行垃圾回收器**
- 按**工作模式**分，可以分为**并发式垃圾回收器**和****独占式垃圾回收器**。并发式垃圾回收器与应用程序线程交替工作，尽可能减少应用程序的停顿时间；独占式垃圾回收器一旦运行，就停止应用程序中的其他所有线程，直到垃圾回收过程完全结束
- 按**碎片处理方式**分，可分为**压缩式垃圾回收器**和**非压缩式垃圾回收器**。压缩式垃圾回收器会在回收完成后，对存活对象进行压缩整理，消除回收后的碎片；非压缩式的垃圾回收器，不进行这步操作
- 按**工作的内存区间**分，可分为**新生代垃圾回收器**和**老年代垃圾回收器**

### 新生代串行收集器
- 单线程
- 独占式
- 复制算法
- **-XX:+UseSerialGC:** 指定使用新生代串行收集器和老年代串行收集器
- Client模式下默认的垃圾收集器

### 老年代串行收集器
- 标记-压缩算法
- 独占式
- **-XX:+UseSerialGC:** 指定使用新生代串行收集器和老年代串行收集器
- **-XX:+UseParNewGC:** 在新生代使用并行收集器,老年代使用串行收集器
- **-XX:+UseParallelGC:** 新生代使用并行回收收集器，老年代使用串行收集器

### 新生代并行收集器
- 多线程
- 独占式
- 复制算法
- **-XX:+UseParNewGC:** 在新生代使用并行收集器,老年代使用串行收集器
- **-XX:+UseConcMarkSweepGC:** 新生代使用并行收集器，老年代使用CMS+串行收集器
- **-XX:ParallelGCThreads:** 指定线程数

### 新生代并行回收收集器
- 多线程
- 独占式
- 复制算法
- 与新生代并行收集器的**不同点**：非常关注系统的吞吐量
- **-XX:+UseParallelGC:** 新生代使用并行回收收集器，老年代使用串行收集器
- **-XX:+UseParallelOldGC:** 新生代和老年代都使用并行回收收集器
- **-XX:MaxGCPauseMillis:** 设置最大垃圾收集停顿时间。其值是一个大于0的证书。收集器在工作时，会调整java堆大小或者其他一些参数，尽可能地把停顿时间控制在MaxGCPauseMillis以内
- **-XX:GCTimeRatio:** 设置吞吐量大小，值是一个0～100之间的整数。假设GCTimeRatio的值为n，那么系统将花费不超过1/(1+n)的时间用于垃圾收集
- **-XX:UseAdaptiveSizePolicy:** 打开自适应GC策略。在这种模式下，新生代的大小、eden和survivor的比例、晋升老年代的对象年龄等参数会被自动调整，以达到在堆大小、吞吐量和停顿时间之间的平衡点

### 老年代并行回收收集器
- 多线程
- 独占式
- 标记-压缩算法
- **-XX:+UseParallelOldGC:** 新生代和老年代都使用并行回收收集器

### CMS收集器
- 主要关注系统停顿时间
- 多线程
- 并发式
- 标记-清除算法
- **-XX:CMSInitiatingOccupancyFraction:** 设置CMS收集器在老年代空间被使用多少后触发。默认为68%
- **-XX:+UseCMSCompactAtFullCollection:** 设置CMS收集器在完成垃圾收集后是否要进行一次内存碎片的整理

### G1收集器
- 服务端的垃圾收集器
- 标记-压缩算法
