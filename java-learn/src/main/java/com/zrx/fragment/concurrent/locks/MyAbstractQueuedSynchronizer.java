package com.zrx.fragment.concurrent.locks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * 内部类 Node 学习
 * <pre>
 *  构造器
 *      Node() = {}                        // 空构造器。只用于 head 和 SHARED
 *      Node(nextWaiter)                   // 由 addWaiter() 调用
 *          this.nextWaiter 就是传入的东西
 *          this.thread = 当前线程
 *          this.next = null
 *          this.prev = null
 *          this.waitStatus = 0
 *      Node(waitStatus)                   // 由 addConditionWaiter() 调用
 *          this.nextWaiter null
 *          this.thread = 当前线程
 *          this.next = null
 *          this.prev = null
 *          this.waitStatus = waitStatus
 *  静态变量
 *      Node SHARED = new Node()    // 用于标记结点处于分享模式
 *      Node EXCLUSIVE = null       // 用于标记结点处于独占模式
 *      CANCELLED = 1               // 线程被取消
 *      SIGNAL = -1                 // 后继线程需要唤醒
 *      CONDITION = -2              // 线程等待于条件
 *      PROPAGATE = -3              // 下次 acquireShared 需要无条件传播
 *                                  // 非负数表示节点不需要信号
 *  成员变量 (5个)
 *      volatile int waitStatus    // 状态
 *      volatile Node prev         // 前驱
 *      volatile Node next         // 后继
 *      volatile Thread thread     // Node 内线程
 *      Node nextWaiter            // 没有 volatile
 *  成员方法
 *      boolean isShared() = nextWaiter == SHARED  // 当前 node 是否处于分享模式
 *      predecessor() = prev                       // 获得前驱
 *      compareAndSetWaitStatus(expect, update)
 *      compareAndSetNext(expect, update)
 *      setPrevRelaxed(prev)                       // 直接设置 prev
 * </pre>
 * <p>
 * AQS 学习
 * <pre>
 *  开始
 * </pre>
 * <p>
 * AQS 学习
 * <pre>
 *  开始
 * </pre>
 * <p>
 * 看不懂的地方
 * unparkSuccessor(node) 中把 node.ws 设为 0，且允许失败
 * unparkSuccessor(node) 中当 node.next 是 null 时，进行反向搜索后继
 * <p>
 * AQS 学习
 * <pre>
 *  开始
 * </pre>
 * <p>
 * 看不懂的地方
 * unparkSuccessor(node) 中把 node.ws 设为 0，且允许失败
 * unparkSuccessor(node) 中当 node.next 是 null 时，进行反向搜索后继
 * <p>
 * AQS 学习
 * <pre>
 *  开始
 * </pre>
 * <p>
 * 看不懂的地方
 * unparkSuccessor(node) 中把 node.ws 设为 0，且允许失败
 * unparkSuccessor(node) 中当 node.next 是 null 时，进行反向搜索后继
 * <p>
 * AQS 学习
 * <pre>
 *  开始
 * </pre>
 * <p>
 * 看不懂的地方
 * unparkSuccessor(node) 中把 node.ws 设为 0，且允许失败
 * unparkSuccessor(node) 中当 node.next 是 null 时，进行反向搜索后继
 * <p>
 * AQS 学习
 * <pre>
 *  开始
 * </pre>
 * <p>
 * 看不懂的地方
 * unparkSuccessor(node) 中把 node.ws 设为 0，且允许失败
 * unparkSuccessor(node) 中当 node.next 是 null 时，进行反向搜索后继
 * <p>
 * AQS 学习
 * <pre>
 *  开始
 * </pre>
 * <p>
 * 看不懂的地方
 * unparkSuccessor(node) 中把 node.ws 设为 0，且允许失败
 * unparkSuccessor(node) 中当 node.next 是 null 时，进行反向搜索后继
 * <p>
 * AQS 学习
 * <pre>
 *  开始
 * </pre>
 * <p>
 * 看不懂的地方
 * unparkSuccessor(node) 中把 node.ws 设为 0，且允许失败
 * unparkSuccessor(node) 中当 node.next 是 null 时，进行反向搜索后继
 * <p>
 * AQS 学习
 * <pre>
 *  开始
 * </pre>
 * <p>
 * 看不懂的地方
 * unparkSuccessor(node) 中把 node.ws 设为 0，且允许失败
 * unparkSuccessor(node) 中当 node.next 是 null 时，进行反向搜索后继
 * <p>
 * AQS 学习
 * <pre>
 *  开始
 * </pre>
 * <p>
 * 看不懂的地方
 * unparkSuccessor(node) 中把 node.ws 设为 0，且允许失败
 * unparkSuccessor(node) 中当 node.next 是 null 时，进行反向搜索后继
 * <p>
 * AQS 学习
 * <pre>
 *  开始
 * </pre>
 * <p>
 * 看不懂的地方
 * unparkSuccessor(node) 中把 node.ws 设为 0，且允许失败
 * unparkSuccessor(node) 中当 node.next 是 null 时，进行反向搜索后继
 * <p>
 * AQS 学习
 * <pre>
 *  开始
 * </pre>
 * <p>
 * 看不懂的地方
 * unparkSuccessor(node) 中把 node.ws 设为 0，且允许失败
 * unparkSuccessor(node) 中当 node.next 是 null 时，进行反向搜索后继
 */

/**
 * AQS 学习
 * <pre>
 *  开始
 * </pre>
 */

/**
 * 看不懂的地方
 * unparkSuccessor(node) 中把 node.ws 设为 0，且允许失败
 * unparkSuccessor(node) 中当 node.next 是 null 时，进行反向搜索后继
 */

/**
 * Description
 * MyAbstractQueuedSynchronizer
 * <p>
 * <p>
 * * Provides a framework for implementing blocking locks and related
 * * synchronizers (semaphores, events, etc) that rely on
 * * first-in-first-out (FIFO) wait queues.  This class is designed to
 * * be a useful basis for most kinds of synchronizers that rely on a
 * * single atomic {@code int} value to represent state. Subclasses
 * * must define the protected methods that change this state, and which
 * * define what that state means in terms of this object being acquired
 * * or released.  Given these, the other methods in this class carry
 * * out all queuing and blocking mechanics. Subclasses can maintain
 * * other state fields, but only the atomically updated {@code int}
 * * value manipulated using methods {link #getState}, {link
 * * #setState} and {link #compareAndSetState} is tracked with respect
 * * to synchronization.
 * 提供框架，用于实现阻塞锁，和相关的同步器
 * 基于 FIFO 先进先出 等待队列
 * 这个类使用 单独的原子变量（int） 来表示状态
 * 子类必须规定这些 protected 方法如何改变这一状态
 * 以及定义，这个状态的含义，以用于对象的获取和释放
 * 有了这些，这个类中其余的方法就可以处理所有的排队、阻塞机制
 * 子类还可以维持其他的状态字段
 * 但是只有原子性的更新 int 值的方法 getState 和 compareAndSetState 被用于实现同步？
 * *
 * * <p>Subclasses should be defined as non-public internal helper
 * * classes that are used to implement the synchronization properties
 * * of their enclosing class.  Class
 * * {code AbstractQueuedSynchronizer} does not implement any
 * * synchronization interface.  Instead it defines methods such as
 * * {link #acquireInterruptibly} that can be invoked as
 * * appropriate by concrete locks and related synchronizers to
 * * implement their public methods.
 * 子类必须定义为一个内部类、作为助手、且不公开，以实现外部类所需要的同步性
 * AQS 不提供同步接口
 * 而是定义类诸如 acquireInterruptibly 的方法，有需要时，可以被调用，以实现外部方法的锁、同步
 * *
 * * <p>This class supports either or both a default <em>exclusive</em>
 * * mode and a <em>shared</em> mode. When acquired in exclusive mode,
 * * attempted acquires by other threads cannot succeed. Shared mode
 * * acquires by multiple threads may (but need not) succeed. This class
 * * does not &quot;understand&quot; these differences except in the
 * * mechanical sense that when a shared mode acquire succeeds, the next
 * * waiting thread (if one exists) must also determine whether it can
 * * acquire as well. Threads waiting in the different modes share the
 * * same FIFO queue. Usually, implementation subclasses support only
 * * one of these modes, but both can come into play for example in a
 * * {link ReadWriteLock}. Subclasses that support only exclusive or
 * * only shared modes need not define the methods supporting the unused mode.
 * 这个类提供 exclusive 独占模式 和 shared 共享模式
 * 独占模式下，当这个类实例被占用（acquired）时，其他线程的尝试性获取（acquire）不会成功
 * 共享模式下，被多个线程占用是可以成功的，下一个等待线程（如果存在），也可以尝试进行获取
 * 不同模式下的等待线程，使用的是同一个 FIFO 队列
 * 通常，子类只支持一种模式
 * 但是无论那种模式，但也可以同时工作？ 如 ReadWriteLock
 * 子类如果只想实现一种模式，可以不用定义另一个模式的方法
 * *
 * * <p>This class defines a nested {link ConditionObject} class that
 * * can be used as a {link Condition} implementation by subclasses
 * * supporting exclusive mode for which method {link
 * * #isHeldExclusively} reports whether synchronization is exclusively
 * * held with respect to the current thread, method {link #release}
 * * invoked with the current {link #getState} value fully releases
 * * this object, and {link #acquire}, given this saved state value,
 * * eventually restores this object to its previous acquired state.  No
 * * {code AbstractQueuedSynchronizer} method otherwise creates such a
 * * condition, so if this constraint cannot be met, do not use it.  The
 * * behavior of {link ConditionObject} depends of course on the
 * * semantics of its synchronizer implementation.
 * 这个类定义了一个内部类 ConditionObject，可以用于实现 Condition（对于独占模式）
 * isHeldExclusively方法 报告这个同步器是不是被当前线程独占
 * release方法 会让状态值完全释放这一对象？
 * acquire方法 最终会让对象进入之前的占用模式
 * AQS 不会创造 condition，除非完成 ConditionObject 的语义
 * *
 * * <p>This class provides inspection, instrumentation, and monitoring
 * * methods for the internal queue, as well as similar methods for
 * * condition objects. These can be exported as desired into classes
 * * using an {@code AbstractQueuedSynchronizer} for their
 * * synchronization mechanics.
 * 这个方法提供了 检查、测量、监控 它内部队列的方法，对 condition 对象也是如此
 * 可以对外暴露
 * *
 * * <p>Serialization of this class stores only the underlying atomic
 * * integer maintaining state, so deserialized objects have empty
 * * thread queues. Typical subclasses requiring serializability will
 * * define a {@code readObject} method that restores this to a known
 * * initial state upon deserialization.
 * 序列化只提供内部的原子 int 状态
 * 所以反序列化得到的线程队列是空的
 * 因此子类在需要可序列化性质时，需要一些处理
 * *
 * * <h2>Usage 使用</h2>
 * *
 * * <p>To use this class as the basis of a synchronizer, redefine the
 * * following methods, as applicable, by inspecting and/or modifying
 * * the synchronization state using {link #getState}, {link
 * * #setState} and/or {link #compareAndSetState}:
 * 使用这个类，需要重新定义以下方法
 * 通过 getState 和 setState 、 compareAndSetState 来检查、修改同步器的状态
 * *
 * * <ul>
 * * <li>{link #tryAcquire}
 * * <li>{link #tryRelease}
 * * <li>{link #tryAcquireShared}
 * * <li>{link #tryReleaseShared}
 * * <li>{link #isHeldExclusively}
 * * </ul>
 * *
 * * Each of these methods by default throws {link
 * * UnsupportedOperationException}.  Implementations of these methods
 * * must be internally thread-safe, and should in general be short and
 * * not block. Defining these methods is the <em>only</em> supported
 * * means of using this class. All other methods are declared
 * * {@code final} because they cannot be independently varied.
 * 默认下，这些方法抛出 UnsupportedOperationException
 * 这些方法的实现必须内部线程安全、短、不阻塞
 * 定义这个方法，是使用这个类唯一支持的方法
 * 所有其他的方法都是 final 修饰，因为他们不能独立的变化
 * *
 * * <p>You may also find the inherited methods from {link
 * * AbstractOwnableSynchronizer} useful to keep track of the thread
 * * owning an exclusive synchronizer.  You are encouraged to use them
 * * -- this enables monitoring and diagnostic tools to assist users in
 * * determining which threads hold locks.
 * 这个类继承了 AbstractOwnableSynchronizer
 * 因此具有追踪 独占了这个同步器的线程 的能力
 * 鼓励你使用他们，来追踪哪个线程拿到了锁
 * *
 * * <p>Even though this class is based on an internal FIFO queue, it
 * * does not automatically enforce FIFO acquisition policies.  The core
 * * of exclusive synchronization takes the form:
 * 虽然这个类基于 FIFO 队列，但不是自动执行 FIFO 策略
 * 独占性同步器的核心是下面这样子的
 * *
 *  * <pre>
 *  * Acquire://获取
 *  *     while (!tryAcquire(arg)) {//尝试获取失败
 *  *        <em>enqueue thread if it is not already queued</em>;//如果没有入队，就入队
 *  *        <em>possibly block current thread</em>;//阻塞自己
 *  *     }
 *  *
 *  * Release://释放
 *  *     if (tryRelease(arg))//尝试释放成功
 *  *        <em>unblock the first queued thread</em>;//唤醒队列中第一个人
 *  * </pre>
 * *
 * * (Shared mode is similar but may involve cascading signals.)
 * 分享模式大致类似，只是有级联信号
 * *
 * * <p id="barging">Because checks in acquire are invoked before
 * * enqueuing, a newly acquiring thread may <em>barge</em> ahead of
 * * others that are blocked and queued.  However, you can, if desired,
 * * define {code tryAcquire} and/or {code tryAcquireShared} to
 * * disable barging by internally invoking one or more of the inspection
 * * methods, thereby providing a <em>fair</em> FIFO acquisition order.
 * * In particular, most fair synchronizers can define {@code tryAcquire}
 * * to return {@code false} if {link #hasQueuedPredecessors} (a method
 * * specifically designed to be used by fair synchronizers) returns
 * * {@code true}.  Other variations are possible.
 * barging - 冲 闯
 * 一个新的 acquiring 线程，可能会冲到前面，比那些在队列中等待的线程还要前
 * 但是你可以在 tryAcquire 和 tryAcquireShared 中实现公平性
 * 具体来说，你可以在 tryAcquire 中返回 false，只要是 hasQueuedPredecessors
 * hasQueuedPredecessors 是一个方法，专门用于公平同步器
 * *
 * * <p>Throughput and scalability are generally highest for the
 * * default barging (also known as <em>greedy</em>,
 * * <em>renouncement</em>, and <em>convoy-avoidance</em>) strategy.
 * * While this is not guaranteed to be fair or starvation-free, earlier
 * * queued threads are allowed to recontend before later queued
 * * threads, and each recontention has an unbiased chance to succeed
 * * against incoming threads.  Also, while acquires do not
 * * &quot;spin&quot; in the usual sense, they may perform multiple
 * * invocations of {@code tryAcquire} interspersed with other
 * * computations before blocking.  This gives most of the benefits of
 * * spins when exclusive synchronization is only briefly held, without
 * * most of the liabilities when it isn't. If so desired, you can
 * * augment this by preceding calls to acquire methods with
 * * "fast-path" checks, possibly prechecking {link #hasContended}
 * * and/or {link #hasQueuedThreads} to only do so if the synchronizer
 * * is likely not to be contended.
 * Throughput - 吞吐量
 * renouncement - 放弃 拒绝
 * convoy-avoidance - 避开车队
 * recontend - 重新招标
 * 对于默认闯入（也称为 greedy、renouncement 和 convoy-avoidance）策略，
 * 吞吐量和可伸缩性通常是最高的。尽管无法保证这是公平的或是无偏向的，
 * 但允许更早加入队列的线程先于更迟加入队列的线程再次争用资源，并且相对于传入的线程，
 * 每个参与再争用的线程都有平等的成功机会。此外，尽管从一般意义上说，
 * 获取并非“自旋”，它们可以在阻塞之前对用其他计算所使用的 tryAcquire
 * 执行多次调用。在只保持独占同步时，这为自旋提供了最大的好处，
 * 但不是这种情况时，也不会带来最大的负担。如果需要这样做，那么可以使用“快速路径”
 * 检查来先行调用 acquire 方法，以这种方式扩充这一点，如果可能不需要争用同步器，
 * 则只能通过预先检查 hasContended() 和/或 hasQueuedThreads() 来确认这一点。
 * *
 * * <p>This class provides an efficient and scalable basis for
 * * synchronization in part by specializing its range of use to
 * * synchronizers that can rely on {@code int} state, acquire, and
 * * release parameters, and an internal FIFO wait queue. When this does
 * * not suffice, you can build synchronizers from a lower level using
 * * {@link java.util.concurrent.atomic atomic} classes, your own custom
 * * {@link java.util.Queue} classes, and {link LockSupport} blocking
 * * support.
 * 通过特殊化其同步器的使用范围，此类为部分同步化提供了一个有效且可伸缩的基础，
 * 同步器可以依赖于 int 型的 state、acquire 和 release 参数，以及一个内部的 FIFO 等待队列。
 * 这些还不够的时候，可以使用 atomic 类、自己的定制 Queue 类和 LockSupport 阻塞支持，
 * 从更低级别构建同步器。
 * *
 * * <h2>Usage Examples 使用示例</h2>
 * *
 * * <p>Here is a non-reentrant mutual exclusion lock class that uses
 * * the value zero to represent the unlocked state, and one to
 * * represent the locked state. While a non-reentrant lock
 * * does not strictly require recording of the current owner
 * * thread, this class does so anyway to make usage easier to monitor.
 * * It also supports conditions and exposes some instrumentation methods:
 * 以下是一个非再进入的互斥锁类，它使用值 0 表示未锁定状态，使用 1 表示锁定状态。
 * 当非重入锁定不严格地需要当前拥有者线程的记录时，此类使得使用监视器更加方便。
 * 它还支持一些条件并公开了一个检测方法：
 * *
 *  * <pre> {@code
 *  * class Mutex implements Lock, java.io.Serializable {
 *  *
 *  *   // Our internal helper class
 *  *   private static class Sync extends AbstractQueuedSynchronizer {
 *  *     // Acquires the lock if state is zero
 *  *     public boolean tryAcquire(int acquires) {
 *  *       assert acquires == 1; // Otherwise unused
 *  *       if (compareAndSetState(0, 1)) {
 *  *         setExclusiveOwnerThread(Thread.currentThread());
 *  *         return true;
 *  *       }
 *  *       return false;
 *  *     }
 *  *
 *  *     // Releases the lock by setting state to zero
 *  *     protected boolean tryRelease(int releases) {
 *  *       assert releases == 1; // Otherwise unused
 *  *       if (!isHeldExclusively())
 *  *         throw new IllegalMonitorStateException();
 *  *       setExclusiveOwnerThread(null);
 *  *       setState(0);
 *  *       return true;
 *  *     }
 *  *
 *  *     // Reports whether in locked state
 *  *     public boolean isLocked() {
 *  *       return getState() != 0;
 *  *     }
 *  *
 *  *     public boolean isHeldExclusively() {
 *  *       // a data race, but safe due to out-of-thin-air guarantees
 *  *       return getExclusiveOwnerThread() == Thread.currentThread();
 *  *     }
 *  *
 *  *     // Provides a Condition
 *  *     public Condition newCondition() {
 *  *       return new ConditionObject();
 *  *     }
 *  *
 *  *     // Deserializes properly
 *  *     private void readObject(ObjectInputStream s)
 *  *         throws IOException, ClassNotFoundException {
 *  *       s.defaultReadObject();
 *  *       setState(0); // reset to unlocked state
 *  *     }
 *  *   }
 *  *
 *  *   // The sync object does all the hard work. We just forward to it.
 *  *   private final Sync sync = new Sync();
 *  *
 *  *   public void lock()              { sync.acquire(1); }
 *  *   public boolean tryLock()        { return sync.tryAcquire(1); }
 *  *   public void unlock()            { sync.release(1); }
 *  *   public Condition newCondition() { return sync.newCondition(); }
 *  *   public boolean isLocked()       { return sync.isLocked(); }
 *  *   public boolean isHeldByCurrentThread() {
 *  *     return sync.isHeldExclusively();
 *  *   }
 *  *   public boolean hasQueuedThreads() {
 *  *     return sync.hasQueuedThreads();
 *  *   }
 *  *   public void lockInterruptibly() throws InterruptedException {
 *  *     sync.acquireInterruptibly(1);
 *  *   }
 *  *   public boolean tryLock(long timeout, TimeUnit unit)
 *  *       throws InterruptedException {
 *  *     return sync.tryAcquireNanos(1, unit.toNanos(timeout));
 *  *   }
 *  * }}</pre>
 * *
 * * <p>Here is a latch class that is like a
 * * {@link java.util.concurrent.CountDownLatch CountDownLatch}
 * * except that it only requires a single {@code signal} to
 * * fire. Because a latch is non-exclusive, it uses the {@code shared}
 * * acquire and release methods.
 * *
 *  * <pre> {@code
 *  * class BooleanLatch {
 *  *
 *  *   private static class Sync extends AbstractQueuedSynchronizer {
 *  *     boolean isSignalled() { return getState() != 0; }
 *  *
 *  *     protected int tryAcquireShared(int ignore) {
 *  *       return isSignalled() ? 1 : -1;
 *  *     }
 *  *
 *  *     protected boolean tryReleaseShared(int ignore) {
 *  *       setState(1);
 *  *       return true;
 *  *     }
 *  *   }
 *  *
 *  *   private final Sync sync = new Sync();
 *  *   public boolean isSignalled() { return sync.isSignalled(); }
 *  *   public void signal()         { sync.releaseShared(1); }
 *  *   public void await() throws InterruptedException {
 *  *     sync.acquireSharedInterruptibly(1);
 *  *   }
 *  * }}</pre>
 * *
 * * @since 1.5
 * * @author Doug Lea
 * <p>
 * Data
 * 2020/5/18-13:02
 *
 * @author zrx
 * @version 1.0
 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer
 */

public abstract class MyAbstractQueuedSynchronizer extends MyAbstractOwnableSynchronizer
        implements java.io.Serializable {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyAbstractQueuedSynchronizer.class);

    private static final long serialVersionUID = 7373984972572414691L;

    /**
     * Creates a new {@code AbstractQueuedSynchronizer} instance
     * with initial synchronization state of zero.
     * 创建新实例，初始同步状态为 0
     */
    protected MyAbstractQueuedSynchronizer() {
        LOGGER.info("init MyAbstractQueuedSynchronizer()创建新实例，初始同步状态为 0");
    }

    /**
     * Wait queue node class.
     * 等待队列中的节点类
     *
     * <p>The wait queue is a variant of a "CLH" (Craig, Landin, and
     * Hagersten) lock queue. CLH locks are normally used for
     * spinlocks.  We instead use them for blocking synchronizers, but
     * use the same basic tactic of holding some of the control
     * information about a thread in the predecessor of its node.  A
     * "status" field in each node keeps track of whether a thread
     * should block.  A node is signalled when its predecessor
     * releases.  Each node of the queue otherwise serves as a
     * specific-notification-style monitor holding a single waiting
     * thread. The status field does NOT control whether threads are
     * granted locks etc though.  A thread may try to acquire if it is
     * first in the queue. But being first does not guarantee success;
     * it only gives the right to contend.  So the currently released
     * contender thread may need to rewait.
     * variant - 变体
     * 等待队列是 CLH 的变体。CLH锁一边是自旋锁
     * 相反，我们使用它们来阻止同步器，但是使用相同的基本策略，即在其节点的前身中保存一些关于线程的控制信息。
     * 一个 状态 字段保存在每个节点中，用于显示线程是否要阻塞
     * 一个节点被唤醒，当他的前身被释放 A node is signalled when its predecessor releases.
     * 队列中的每个节点，是一个 特定通知样式 监视器，保存有一个等待线程
     * ans
     * 队列中的第一个节点的线程会尝试 获取，但是这部保证成功
     * 仅仅是给予了争夺的权利
     * 因此当前被释放的争夺者，可能会再次等待
     *
     * <p>To enqueue into a CLH lock, you atomically splice it in as new
     * tail. To dequeue, you just set the head field.
     * splice - 结合
     * 要加入一个 CLH 队列，你要原子性的接合上，变成新的队尾
     * 要出队，（只要设置为头？）/（设置新头？）
     * <pre>
     *      +------+  prev +-----+       +-----+
     * head |      | <---- |     | <---- |     |  tail
     *      +------+       +-----+       +-----+
     * </pre>
     *
     * <p>Insertion into a CLH queue requires only a single atomic
     * operation on "tail", so there is a simple atomic point of
     * demarcation from unqueued to queued. Similarly, dequeuing
     * involves only updating the "head". However, it takes a bit
     * more work for nodes to determine who their successors are,
     * in part to deal with possible cancellation due to timeouts
     * and interrupts.
     * 插入 CLH 队列，需要一次原子操作，于队尾。因此在“队外”和“队中”只有一个原子操作之别
     * 同样的，出队包括更新头节点。
     * 但是，需要一些额外的工作确定谁成功了
     * 还有一部分是因为可能“这个操作被取消了 cancellation”，或者遇到了“时限 timeouts”、“中断”
     *
     * <p>The "prev" links (not used in original CLH locks), are mainly
     * needed to handle cancellation. If a node is cancelled, its
     * successor is (normally) relinked to a non-cancelled
     * predecessor. For explanation of similar mechanics in the case
     * of spin locks, see the papers by Scott and Scherer at
     * http://www.cs.rochester.edu/u/scott/synchronization/
     * 前驱需要处理“取消事件”
     * 如果一个节点被取消了，他的后继 successor 被重新接到一个没有被取消的前驱上
     * 看看论文吧
     *
     * <p>We also use "next" links to implement blocking mechanics.
     * The thread id for each node is kept in its own node, so a
     * predecessor signals the next node to wake up by traversing
     * next link to determine which thread it is.  Determination of
     * successor must avoid races with newly queued nodes to set
     * the "next" fields of their predecessors.  This is solved
     * when necessary by checking backwards from the atomically
     * updated "tail" when a node's successor appears to be null.
     * (Or, said differently, the next-links are an optimization
     * so that we don't usually need a backward scan.)
     * next 用于实现阻塞机制
     * 因为每个结点保存有 他的 thread id，所以一个前驱发信号到下一个节点，
     * 目的是唤醒，这个机制通过链传播，最终将决定到底是唤醒哪一个线程
     * “确认后继” -- 一定要避免和新入队的节点竞争，后者设定 next 字段表示他的前驱
     * 这件事情可以这么解决 - 当需要确认，往后开始遍历，从原子更新的尾巴开始，当一个节点的后继是 null 时
     * 总是 next 字段，是一个优化，避免了往后搜索
     *
     * <p>Cancellation introduces some conservatism to the basic
     * algorithms.  Since we must poll for cancellation of other
     * nodes, we can miss noticing whether a cancelled node is
     * ahead or behind us. This is dealt with by always unparking
     * successors upon cancellation, allowing them to stabilize on
     * a new predecessor, unless we can identify an uncancelled
     * predecessor who will carry this responsibility.
     * “取消”引入了一些保守主义到基本的算法中。
     * 因为我们必须 poll 轮询，以知道其他节点的“取消”
     * 我们可能会忽略有一个被取消的节点在我们的前面或后面
     * 这个是这么解决的 - 一旦取消了，总是唤醒后继者，允许他们稳定咋一个新的前驱上
     * 除非我们能识别到一个没有取消的前驱，而他可以负责
     * （unless 为什么不是 until）
     *
     * <p>CLH queues need a dummy header node to get started. But
     * we don't create them on construction, because it would be wasted
     * effort if there is never contention. Instead, the node
     * is constructed and head and tail pointers are set upon first
     * contention.
     * CLH 队列需要一个假头，以启动。
     * 但是我们不在构造器中创建它，因为这可能发生不必要的浪费（在没有 contention 争论的时候）
     * 只有发生第一次冲突时，才会构建 头 和 尾巴
     *
     * <p>Threads waiting on Conditions use the same nodes, but
     * use an additional link. Conditions only need to link nodes
     * in simple (non-concurrent) linked queues because they are
     * only accessed when exclusively held.  Upon await, a node is
     * inserted into a condition queue.  Upon signal, the node is
     * transferred to the main queue.  A special value of status
     * field is used to mark which queue a node is on.
     * 等待在 Conditions 中的线程，用的是同样的节点，但是使用额外的链
     * Conditions 仅仅只需要成链，他不是并发的，因为 Conditions 对象总是独占的持有
     * 一旦 await 等待，节点就会被 transferred 转移到条件队列上
     * 一旦有信号 signal，节点被转移到主链上
     * 状态字段的特定值指示节点在哪个队列上
     *
     * <p>Thanks go to Dave Dice, Mark Moir, Victor Luchangco, Bill
     * Scherer and Michael Scott, along with members of JSR-166
     * expert group, for helpful ideas, discussions, and critiques
     * on the design of this class.
     * 感谢
     */
    static final class Node {

        /**
         * Marker to indicate a node is waiting in shared mode
         * 标记之暗示节点等待于分享模式者
         * 为什么 mode的类型仍然是 Node，而不是直接使用int数字呢？
         * 更新：因为nextWaiter字段需要在条件等待队列中试用，
         * 条件等待队列的元素仍然还是Node~！
         */
        static final MyAbstractQueuedSynchronizer.Node SHARED = new MyAbstractQueuedSynchronizer.Node();

        /**
         * Marker to indicate a node is waiting in exclusive mode
         * 标记之按时节点处于独占模式者
         * 为什么    EXCLUSIVE的值竟然是null？ 太不可思议了！ 不好理解啊！
         * 更新：其实这个时候 条件等待队列 还未开始建立起来，故 EXCLUSIVE 为 null 是合理的；
         */
        static final MyAbstractQueuedSynchronizer.Node EXCLUSIVE = null;

        /**
         * waitStatus value to indicate thread has cancelled.
         * 是一个 waitStatus 用于暗示线程被取消了
         */
        static final int CANCELLED = 1;

        /**
         * waitStatus value to indicate successor's thread needs unparking.
         * 是一个 waitStatus 用于暗示线程需要唤醒
         */
        static final int SIGNAL = -1;

        /**
         * waitStatus value to indicate thread is waiting on condition.
         * 是一个 waitStatus 用于暗示线程等待于条件上
         */
        static final int CONDITION = -2;

        /**
         * waitStatus value to indicate the next acquireShared should
         * unconditionally propagate.
         * 是一个 waitStatus 用于暗示下次 共享模式的获取 需要无条件传播
         */
        static final int PROPAGATE = -3;

        /**
         * Status field, taking on only the values:
         * <pre>
         *   SIGNAL:     The successor of this node is (or will soon be)
         *               blocked (via park), so the current node must
         *               unpark its successor when it releases or
         *               cancels. To avoid races, acquire methods must
         *               first indicate they need a signal,
         *               then retry the atomic acquire, and then,
         *               on failure, block.
         *               是一个 waitStatus 用于暗示线程需要唤醒
         *               当前 node 的后继被阻塞、将立马被阻塞（通过 park）
         *               那么当前 node 必须 unpark 它的后继，当它释放或取消的时候
         *               为了避免竞争，acquire 方法必须首先暗示他们需要一个信号
         *               然后再次尝试原子性的 acquire
         *               之后，如果失败，就阻塞
         *
         *   CANCELLED:  This node is cancelled due to timeout or interrupt.
         *               Nodes never leave this state. In particular,
         *               a thread with cancelled node never again blocks.
         *               是一个 waitStatus 用于暗示线程被取消了
         *               这个 node 被取消了，因为 timeout 或 中断
         *               节点们从不离开这个状态
         *               具体来说，一个取消了的节点不会再被阻塞
         *
         *   CONDITION:  This node is currently on a condition queue.
         *               It will not be used as a sync queue node
         *               until transferred, at which time the status
         *               will be set to 0. (Use of this value here has
         *               nothing to do with the other uses of the
         *               field, but simplifies mechanics.)
         *               是一个 waitStatus 用于暗示线程等待于条件上
         *               这个节点当前在一个条件队列上
         *               他不会用于同步队列只到被转移，在那个时候状态会被设为0
         *               使用这个值和这个字段的其他用途无关，但是简化机制
         *
         *   PROPAGATE:  A releaseShared should be propagated to other
         *               nodes. This is set (for head node only) in
         *               doReleaseShared to ensure propagation
         *               continues, even if other operations have
         *               since intervened.
         *               是一个 waitStatus 用于暗示下次 共享模式的获取 需要无条件传播
         *               一个共享模式的释放，需要传播到其他的节点
         *               这个仅仅在头节点中设置，在共享模式释放，用于确保传播的继续
         *               即使有其他的操作干预
         *
         *   0:          None of the above
         *               其他
         * </pre>
         * waitStatus 需要仔细的解释， doc文档也进行了详细的解释：（可见它的重要和复杂程度 ）
         * <p>
         * SIGNAL 当前node的继任者（也就是下一个node）应该是一件处于阻塞状态，
         * 或者很快将会被阻塞，为什么这里说“很快将”呢，有点难理解； // 2020年7月17日 因为park/unpark是不分先后的
         * 所以呢，它在它需要释放资源或取消的时候 唤醒它的继任者，
         * 不然就永远无法得以唤醒！！（因为也没有了其它的手段） 。
         * 为了避免竞争，acquire 方法应该首先表明它们需要一个信号，
         * 然后重新执行原子性的acquire方法，然后如果acquire失败，那么阻塞；
         * ———— 这里又有些不好理解了，为什么需要事先表明一下呢？
         * <p>
         * CANCELLED 表示当前node由于超时或者中断被取消了，node一旦处于这个状态，
         * 那么它永远也不会改变这个状态，而且会最终被删除，因为已经取消了，线程也无法再次得到执行。
         * <p>
         * CONDITION 表示node正处于一个条件队列，它将不会被用于同步队列，
         * 除非被转移到了同步队列；（ 也就是说AQS 其实内部维护着两个队列，
         * 一个是同步队列sync queue ，另外一个是条件队列condition queue ），
         * 转移的时候，waitStatus 会被设置为0，为什么0，这是为了简化（具体如何简化，未知。。）
         * <p>
         * PROPAGATE 表示 releaseShared 方法应该被传播扩散到其他的所有的node，
         * 这个状态由doReleaseShared 方法来进行设置，以确保传播扩散得以继续下去，
         * （为什么需要传播扩散？ ） 即使被其他操作干涉了。 有点难以理解
         * <p>
         * The values are arranged numerically to simplify use.
         * Non-negative values mean that a node doesn't need to
         * signal. So, most code doesn't need to check for particular
         * values, just for sign.
         * 数值化仅仅是便于使用，非负数表示节点不需要信号
         * 所以大多数代码不需要具体确认是哪个值
         * <p>
         * The field is initialized to 0 for normal sync nodes, and
         * CONDITION for condition nodes.  It is modified using CAS
         * (or when possible, unconditional volatile writes).
         * 初始值 0 ，为了通常同步节点，或者 CONDITION 为了条件节点
         * 通过 CAS 修改它
         */
        volatile int waitStatus;

        /**
         * Link to predecessor node that current node/thread relies on
         * for checking waitStatus. Assigned during enqueuing, and nulled
         * out (for sake of GC) only upon dequeuing.  Also, upon
         * cancellation of a predecessor, we short-circuit while
         * finding a non-cancelled one, which will always exist
         * because the head node is never cancelled: A node becomes
         * head only as a result of successful acquire. A
         * cancelled thread never succeeds in acquiring, and a thread only
         * cancels itself, not any other node.
         * 应该这个 prev 就是为了看到前置节点的 waitStatus 的
         * 入队时赋值
         * 出队是置空
         * 出现前置节点取消，就往前找新的节点，一定能找到，因为 head
         * 链接到当前节点/线程用来检查等待状态的前置节点。
         * 在排队时分配，只有在排队时才清空(为了便于垃圾收集)。
         * 此外，在取消前一个节点时，我们会短路，同时找到一个未取消的节点，
         * 该节点将始终存在，因为头节点从未被取消:只有成功获取后，节点才会成为头节点。
         * 被取消的线程永远不会成功获取，并且一个线程只取消自己，而不是任何其他节点。
         */
        volatile MyAbstractQueuedSynchronizer.Node prev;

        /**
         * Link to the successor node that the current node/thread
         * unparks upon release. Assigned during enqueuing, adjusted
         * when bypassing cancelled predecessors, and nulled out (for
         * sake of GC) when dequeued.  The enq operation does not
         * assign next field of a predecessor until after attachment,
         * so seeing a null next field does not necessarily mean that
         * node is at end of queue. However, if a next field appears
         * to be null, we can scan prev's from the tail to
         * double-check.  The next field of cancelled nodes is set to
         * point to the node itself instead of null, to make life
         * easier for isOnSyncQueue.
         * 指向后继。
         * 当当前节点被释放时，需要 unpark 这个 next
         * 入队时赋值
         * 出队时置空
         * 会调整他，当绕过被取消的前驱时。
         * 入队操作不会赋值前驱的 next 字段，只到附着完成之后（可能中途挂起了？）
         * 所以所看到一个 空的 next 字段并不意味着节点在队尾
         * 当 next == null 时，我们可以从 tail 开始扫描
         * 一个取消了的节点，他的 next 设为 他自己，而不是 null
         * 以使isOnSyncQueue的工作更加轻松
         * <p/>
         * 链接到当前节点/线程在发布时未解释的后续节点。
         * 在排队期间分配，在绕过取消的前置任务时调整，在出列时清空(为了保证安全)。
         * enq操作直到附加之后才分配前一个字段的下一个字段，
         * 因此看到空的下一个字段不一定意味着节点在队列的末尾。
         * 然而，如果下一个字段看起来是空的，我们可以从尾部扫描前一个字段以进行复查。
         * 取消的节点的下一个字段被设置为指向节点本身，而不是空值，
         * 以使isOnSyncQueue的工作更加轻松。
         */
        volatile MyAbstractQueuedSynchronizer.Node next;

        /**
         * The thread that enqueued this node.  Initialized on
         * construction and nulled out after use.
         * 线程，在构造器中初始化
         * 用完后置空
         */
        volatile Thread thread;

        /**
         * Link to next node waiting on condition, or the special
         * value SHARED.  Because condition queues are accessed only
         * when holding in exclusive mode, we just need a simple
         * linked queue to hold nodes while they are waiting on
         * conditions. They are then transferred to the queue to
         * re-acquire. And because conditions can only be exclusive,
         * we save a field by using special value to indicate shared
         * mode.
         * 两个next疯了
         * 因为条件是独占访问，所以没有并发
         * AQS的条件等待队列，正是通过这个变量进行维护的！！！~~~。
         * <p/>
         * 链接到下一个等待条件的节点，或特殊值SHARED。
         * 因为条件队列只有在独占模式下才被访问，所以我们只需要一个简单的链接队列来保存等待条件的节点。
         * 然后它们被转移到队列中重新获取。因为条件只能是排他的，
         * 所以我们通过使用特殊值来表示共享模式来保存字段。
         *
         * 2020年7月18日 本宝宝现在懂了
         * 这个 nextWaiter 根本就不是一个线程
         * 仅仅是 SHARED 或 EXCLUSIVE
         * 对不，仅仅是没有 CONDITION 的情况下才是这样的
         */
        MyAbstractQueuedSynchronizer.Node nextWaiter;

        /**
         * Returns true if node is waiting in shared mode.
         * 如果 nextWaiter == SHARED 则表示 当前 node 处于共享模式
         * 还有可能是 EXCLUSIVE ？
         * 还有可能是 处于 condition 模式
         */
        final boolean isShared() {
            return nextWaiter == SHARED;
        }

        /**
         * 获得前驱
         * Returns previous node, or throws NullPointerException if null.
         * Use when predecessor cannot be null.  The null check could
         * be elided, but is present to help the VM.
         *
         * @return the predecessor of this node
         */
        final MyAbstractQueuedSynchronizer.Node predecessor() {
            MyAbstractQueuedSynchronizer.Node p = prev;
            if (p == null)
                throw new NullPointerException();
            else
                return p;
        }

        /**
         * Establishes initial head or SHARED marker.
         * 仅仅用于初始化 head 和 SHARED 标记的空构造器
         */
        Node() {
        }

        /**
         * Constructor used by addWaiter.
         * addWaiter 使用的构造器 传入一个 Node
         * 为什么需要把下一个也设置出来呢？ 为什么不是上一个？ 一般线程不是被添加到CLH的末端吗？
         */
        Node(Node nextWaiter) {
            this.nextWaiter = nextWaiter;
            THREAD.set(this, Thread.currentThread());

            // 返回 this
            // this.nextWaiter 就是传入的东西
            // this.thread = 当前线程
            // this.next = null
            // this.prev = null
            // this.waitStatus = 0
        }

        /**
         * Constructor used by addConditionWaiter.
         * addConditionWaiter 使用的构造器
         */
        Node(int waitStatus) {
            WAITSTATUS.set(this, waitStatus);
            THREAD.set(this, Thread.currentThread());

            // 返回 this
            // this.nextWaiter null
            // this.thread = 当前线程
            // this.next = null
            // this.prev = null
            // this.waitStatus = waitStatus
        }

        /**
         * CASes waitStatus field.
         */
        final boolean compareAndSetWaitStatus(int expect, int update) {
            return WAITSTATUS.compareAndSet(this, expect, update);
        }

        /**
         * CASes next field.
         */
        final boolean compareAndSetNext(MyAbstractQueuedSynchronizer.Node expect, MyAbstractQueuedSynchronizer.Node update) {
            return NEXT.compareAndSet(this, expect, update);
        }

        /**
         * 直接设置 prev
         *
         * @param p node set as prev
         */
        final void setPrevRelaxed(MyAbstractQueuedSynchronizer.Node p) {
            PREV.set(this, p);
        }

        // VarHandle mechanics
        private static final VarHandle NEXT;
        private static final VarHandle PREV;
        private static final VarHandle THREAD;
        private static final VarHandle WAITSTATUS;

        static {
            try {
                MethodHandles.Lookup l = MethodHandles.lookup();
                NEXT = l.findVarHandle(MyAbstractQueuedSynchronizer.Node.class, "next", MyAbstractQueuedSynchronizer.Node.class);
                PREV = l.findVarHandle(MyAbstractQueuedSynchronizer.Node.class, "prev", MyAbstractQueuedSynchronizer.Node.class);
                THREAD = l.findVarHandle(MyAbstractQueuedSynchronizer.Node.class, "thread", Thread.class);
                WAITSTATUS = l.findVarHandle(MyAbstractQueuedSynchronizer.Node.class, "waitStatus", int.class);
            } catch (ReflectiveOperationException e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }

    /**
     * Head of the wait queue, lazily initialized.  Except for
     * initialization, it is modified only via method setHead.  Note:
     * If head exists, its waitStatus is guaranteed not to be
     * CANCELLED.
     * 等待队列的头。volatile
     * 懒初始化。
     * 只有 setHead() 方法才能修改这个字段。
     * 注意：head.waitStatus 永远不会是 CANCELLED (1)
     */
    private transient volatile MyAbstractQueuedSynchronizer.Node head;

    /**
     * Tail of the wait queue, lazily initialized.  Modified only via
     * method enq to add new wait node.
     * 等待队列的尾巴。volatile
     * 懒初始化。
     * 只有 enq() 方法才能修改它，这个方法目的是 增加一个等待节点
     */
    private transient volatile MyAbstractQueuedSynchronizer.Node tail;

    /**
     * The synchronization state.
     * 同步器的状态 volatile
     * 要注意和 node.waitStatus 区分开
     */
    private volatile int state;

    /**
     * Returns the current value of synchronization state.
     * This operation has memory semantics of a {@code volatile} read.
     * state 的 getter （可见）
     * 这个方法触发 内存语义（memory semantics） volatile 读
     *
     * @return current state value
     */
    protected final int getState() {
        return state;
    }

    /**
     * Sets the value of synchronization state.
     * This operation has memory semantics of a {@code volatile} write.
     * state 的 setter（可见）
     * 触发 volatile 写
     *
     * @param newState the new state value
     */
    protected final void setState(int newState) {
        state = newState;
    }

    /**
     * Atomically sets synchronization state to the given updated
     * value if the current state value equals the expected value.
     * This operation has memory semantics of a {@code volatile} read
     * and write.
     * 原子性的设定同步器的状态
     * 具有 volatile 的读写
     *
     * @param expect the expected value
     * @param update the new value
     * @return {@code true} if successful. False return indicates that the actual
     * value was not equal to the expected value.
     */
    protected final boolean compareAndSetState(int expect, int update) {
        return STATE.compareAndSet(this, expect, update);
    }

    // Queuing utilities 队列操作

    /**
     * The number of nanoseconds for which it is faster to spin
     * rather than to use timed park. A rough estimate suffices
     * to improve responsiveness with very short timeouts.
     * 在 1000 ns 内，使用自旋而不是 park
     * 粗略估计，虽然 1000 ns 很短，但足以提高响应度
     *
     */
    static final long SPIN_FOR_TIMEOUT_THRESHOLD = 1000L;

    /**
     * Inserts node into queue, initializing if necessary. See picture above.
     * 把 node 入队（核心 compareAndSetTail 把 node 设为新队尾）
     * 如果不并发，就是：
     *      node.prev = tail;
     *      tail.next = node;
     *      tail = node;
     * 因为懒初始化机制，所以要检查是否初始化
     *
     * @param node the node to insert
     * @return node's predecessor 改 node 前驱，也就是 oldTail
     */
    private Node enq(Node node) {
        for (; ; ) { // AQS
            Node oldTail = tail; // 旧尾巴 volatile 读
            if (oldTail != null) { // 已经初始化
                // 直接让 node.prev = oldTail
                node.setPrevRelaxed(oldTail);
                // CAS 尾巴
                if (compareAndSetTail(oldTail, node)) {
                    // CAS 成功
                    // 旧尾巴.next = 这个 node
                    oldTail.next = node;
                    // 返回旧尾巴
                    return oldTail;
                }
            } else {
                // 先初始化同步队列
                initializeSyncQueue();
            }
        }
    } //OK

    /**
     * Creates and enqueues node for current thread and given mode.
     * 当前线程入队，并带上模式
     * 第一步，构造 node：
     *  node.thread = invoker
     *  node.nextWaiter = mode // 只有 Node.EXCLUSIVE 和 Node.SHARED 两种
     * 第二步，CAS 入队，和enq(node)相同
     * 第三步，返回 新创建的node。注意enq(node)=oldTail
     *
     * 一句话 addWaiter(mode) = enq and return newNode
     *
     * @param mode Node.EXCLUSIVE for exclusive, Node.SHARED for shared
     * @return the new node
     */
    private Node addWaiter(Node mode) {
        // *      Node(nextWaiter)                   // 由 addWaiter() 调用
        // *          this.nextWaiter 就是传入的东西
        // *          this.thread = 当前线程
        // *          this.next = null
        // *          this.prev = null
        // *          this.waitStatus = 0
        // mode 是一个 node 只有 Node.EXCLUSIVE 和 Node.SHARED 两种

        Node node = new Node(mode);

        // node.thread = invoker
        // node.nextWaiter = mode

        // node 节点入队
        for (; ; ) {
            Node oldTail = tail; // 旧队尾
            if (oldTail != null) {
                node.setPrevRelaxed(oldTail); // 设置 prev
                if (compareAndSetTail(oldTail, node)) { // cas 更新队尾，内存屏障，禁止重排序
                    oldTail.next = node; // 设置 next

                    return node;
                }
            } else {
                // 旧队尾为空，说明队列没有初始化
                initializeSyncQueue();
            }
        }
    } //OK



    /**
     * Sets head of queue to be node, thus dequeuing. Called only by
     * acquire methods.  Also nulls out unused fields for sake of GC
     * and to suppress unnecessary signals and traversals.
     * 直接把把 node 设为 头节点。没有 CAS
     * 就是 出队 操作。（看来是个假头）
     *
     * @param node the node
     */
    private void setHead(Node node) {
        // 没有 CAS
        head = node;

        // 把无用的字段置空。为了 GC 和抑制无必要的唤醒信号和遍历

        // thread置空？
        node.thread = null;

        // prev 置空，必须的。
        node.prev = null;
    }

    /**
     * Wakes up node's successor, if one exists.
     * 唤醒 node 的后继，如果存在后继
     * 看不懂：
     * 第一个：node.ws 设为 0
     * 第二个：node.next == null 时，从 tail 反向搜索
     *
     * 调用该方法的方法
     * @see MyAbstractQueuedSynchronizer#doReleaseShared()
     * @see MyAbstractQueuedSynchronizer#cancelAcquire(Node)
     *
     * @param node the node
     */
    private void unparkSuccessor(Node node) {
        /*
         * If status is negative (i.e., possibly needing signal) try
         * to clear in anticipation of signalling.  It is OK if this
         * fails or if status is changed by waiting thread.
         * ws 是负数，说明需要信号（前文：非负数表示节点不需要信号）
         * 那就把 node.ws 设为 0 ，表示他不需要信号？？？看不懂啊
         * 允许这个 CAS 失败？？更看不懂了
         *
         * in anticipation of 预期
         */

        // 到底是谁这么缺德呢？唤醒 node 的后继时，node自己的 ws 还是负数？
        // 真缺德啊
        //
        int ws = node.waitStatus;
        if (ws < 0)
            node.compareAndSetWaitStatus(ws, 0);

        /*
         * Thread to unpark is held in successor, which is normally
         * just the next node.  But if cancelled or apparently null,
         * traverse backwards from tail to find the actual
         * non-cancelled successor.
         * 需要被唤醒的线程是放在后继中的。
         * 一般来说就是 node.next.thread
         * 但是如果 node.next 是null，或者 node.next.ws>0 那就找其他的后继
         *
         */
        Node s = node.next; // s == 后继

        // 这里判断 s.wa>0 可以理解，说明 s 不需要信号
        // 但是为什么需要判断 node.next == null？如果是 null 方法直接返回不好吗？
        // 所以没有看懂之后的 for 循环反向搜索的意义
        if (s == null || s.waitStatus > 0 /*说明这个后继不需要被唤醒*/) {

            s = null;
            // 从尾巴开始找？亮瞎狗眼
            // 网友回答：为什么需要反向呢？ 因为 node.next 可能是 null， 自然无法往后搜索，那么保守起见，反向获取比较安全
            for (Node p = tail; p != node && p != null; p = p.prev)

                // 确保它需要被唤醒
                if (p.waitStatus <= 0)
                    // 找到了，但是不 break？看来可以找到离 node 最近的一个需要被唤醒的后继
                    s = p;
        }

        // 总而言之，终于找到一个需要被唤醒的后继了
        if (s != null) // 找不到就算了
            LockSupport.unpark(s.thread);


        // 网友：node 的后继已经被唤醒，一般来说就表示了 node 对应的线程已经执行完毕，那么它应该立即出队，但是AQS不是这样做的。
        // 而是呢，而是在后继 node 醒来之后重新去获取资源，获取成功之后才重新设置head，然后将当前 node 出队。具体参见 比如 acquireQueued
    }

    /**
     * Release action for shared mode -- signals successor and ensures
     * propagation. (Note: For exclusive mode, release just amounts
     * to calling unparkSuccessor of head if it needs signal.)
     * 共享模式下的释放操作。通知后继，并确保进行广播
     * 注意：在独占模式下的释放，仅仅是 调用unparkSuccessor(head)
     */
    private void doReleaseShared() {
        /*
         * Ensure that a release propagates, even if there are other
         * in-progress acquires/releases.  This proceeds in the usual
         * way of trying to unparkSuccessor of head if it needs
         * signal. But if it does not, status is set to PROPAGATE to
         * ensure that upon release, propagation continues.
         * Additionally, we must loop in case a new node is added
         * while we are doing this. Also, unlike other uses of
         * unparkSuccessor, we need to know if CAS to reset status
         * fails, if so rechecking.
         * 确保释放可以传播，即使其他的acquires/releases操作正在同步进行之中
         * 一般情况下，当 head.ws == SIGNAL 时，表示 head 的后继需要唤醒，那就遂其所愿
         * 但是，如果 head.ws 不是 SIGNAL，那就设为 PROPAGATE，以确保在释放时，传播继续
         * 另外，我们必须使用循环，以免同时存在新节点加入。
         * 最后，不像其他方法中的 unparkSuccessor，我们需要知道 CAS 是否失败，若失败则重新检查
         */

        for (; ; ) {
            Node h = head; // 拿到头
            if (h != null && h != tail) { // 头非空 && 头不是尾巴（当头==尾巴时，表示队列是空的？）
                int ws = h.waitStatus; // 头的 ws
                if (ws == Node.SIGNAL) { // h 的后继线程需要唤醒
                    if (!h.compareAndSetWaitStatus(Node.SIGNAL, 0)) // 把 ws CAS 为 0，若失败，则重试
                        continue;            // loop to recheck cases
                    unparkSuccessor(h); // 唤醒 h 的后继（注意不是 h 自己，毕竟 h.thread==null）
                } else if (ws == 0 && // 看来自己已经把 ws 设为 0 了，或者别人做的
                        !h.compareAndSetWaitStatus(0, Node.PROPAGATE)) // 只有当 ws = 0 时，才 CAS 到传播
                    continue;                // loop on failed CAS
            }

            // 说明我上面没有遇到 continue，而且一通操作后，head也没有变化。这才退出循环
            if (h == head)                   // loop if head changed
                break;
        }
    }

    /**
     * Sets head of queue, and checks if successor may be waiting
     * in shared mode, if so propagating if either propagate > 0 or
     * PROPAGATE status was set.
     * 设置头节点，同时检查后继是不是处于共享模式的等待
     * 如果是的，那么当以下两种情况时，进行传播
     * 第一，入参 propagate > 0
     * 第二，已经有人设定了要传播
     *
     * 也就是说，这里的 propagate > 0 表示一定传播，但是就算不是的，也有很大机会发出传播
     *
     * @param node the node
     * @param propagate the return value from a tryAcquireShared
     */
    private void setHeadAndPropagate(Node node, int propagate) {
        //propagate 当作了布尔使用

        // 保存旧头 h = oldHead
        Node h = head; // Record old head for check below

        // 设置新头。这是一个极其暴力的方法
        //        // 没有 CAS
        //        head = node;
        //
        //        // 把无用的字段置空。为了 GC 和抑制无必要的唤醒信号和遍历
        //
        //        // thread置空？
        //        node.thread = null;
        //
        //        // prev 置空，必须的。
        //        node.prev = null;
        setHead(node);

        /*
         * Try to signal next queued node if:
         *   Propagation was indicated by caller,
         *     or was recorded (as h.waitStatus either before
         *     or after setHead) by a previous operation
         *     (note: this uses sign-check of waitStatus because
         *      PROPAGATE status may transition to SIGNAL.)
         * and
         *   The next node is waiting in shared mode,
         *     or we don't know, because it appears null
         *
         * The conservatism in both of these checks may cause
         * unnecessary wake-ups, but only when there are multiple
         * racing acquires/releases, so most need signals now or soon
         * anyway.
         * 尝试发送信号给 node 的下一个节点，当以下任意一点满足时
         *  1. 方法调用者决定传播 propagate > 0
         *  2. 上次操作后，留下的 ws 指明要传播
         * （即使是 SIGNAL 也传播，不仅仅是 PROPAGATE。因为 PROPAGATE 状态可能转换为 SIGNAL。谁会做这种事情呢？）
         *
         * 这些保守的检测可能会导致没有必要的唤醒
         * 但是仅当多线程竞争 acquires/releases 时才会
         * 所以大多数情况下，都是需要信号的
         * （看样子唤醒没啥大不了的？也就是说，唤醒的线程还会再检查以下自己该不该行动？？）
         */
        if (propagate > 0 || // 调用者明确指出需要传播
                // 下面四种情况一般都不会出现吧...
                h == null || // 旧头为空，这是什么情况才会出现的呢？
                h.waitStatus < 0 || // doReleaseShared() 方法中，如果头.ws==0，就会CAS为PROPAGATE(-3)，但是在哪个方法中没有进行唤醒动作，看来在这里唤醒了
                (h = head) == null // 新头为空？
                || h.waitStatus < 0 // 新头ws<0，大概情况和 旧头.ws<0 相同
        ) {
            Node s = node.next; // 没有并发下，node就是新头，s排第一个
            if (s == null || // s==null 很有可能呢，毕竟next不靠谱
                    s.isShared()) // s 等待于共享模式。s.nextWaiter == SHARED;
                doReleaseShared();
        }
    }

    // Utilities for various versions of acquire 多种 acquire 方法

    /**
     * Cancels an ongoing attempt to acquire.
     * 取消一个正在 acquire 的尝试
     *
     * 这个方法的核心就是 node.waitStatus = Node.CANCELLED;
     * 把 node 的 ws 无条件设为 取消
     *
     * 至于其他的代码，旨在于把 node 移出队列
     * 方法是：从 node 往前找，找到一个需要信号的节点 pred，然后让 pred.next = node.next
     *
     * 最后，如果 node 不是 tail，那么有责任去唤醒自己的后继，至于后继需不需要唤醒，暂且不管
     * 1. 如果 node 可以往队伍前面找到一个 pred，发现它有责任唤醒后面的人，那就放心大胆的任务交给他
     * 2. 但是如果 pred 不太对劲，那就自己调用 unparkSuccessor(node) 亲自唤醒
     *
     * @param node the node
     */
    private void cancelAcquire(Node node) {
        // Ignore if node doesn't exist
        // 防止空
        if (node == null)
            return;

        // 首先就把 node 中的线程置空
        node.thread = null;

        // Skip cancelled predecessors
        // 跳过取消了的前驱
        // ws 非负数表示节点不需要信号

        Node pred = node.prev;
        while (pred.waitStatus > 0)
            node.prev = pred = pred.prev;

        // predNext is the apparent node to unsplice. CASes below will
        // fail if not, in which case, we lost race vs another cancel
        // or signal, so no further action is necessary, although with
        // a possibility that a cancelled node may transiently remain
        // reachable.
        // predNext 变量是显而易见需要被取消胶接的，否则下面的CAS方法就会失败，
        // 如果失败，说明我们在同其他取消、信号操作的竞争中失败了，所以不需要更多的其他操作
        // 即使一个被取消的 node 还在队伍中（也没关系）
        // 大概意思就是说 CAS 设置 predNext 失败了，不要急，总有人会删除的
        // 总之，后面的  node.waitStatus = Node.CANCELLED  一定会执行，所以这个方法的核心：取消 node 已经完成了
        // 而把自己和自己之前的 ws>0 的节点移除，这个操作失败了也没事
        // 大不了别人再多走几步

        // 总之先拿到 predNext ，因为一般情况下 predNext 就是 node 自己，是需要取消的，也就是从等待队列中移除
        // 其他情况下 predNext -> ... -> node自己 这条链上的所有线程，都是不需要信号的，需要移除
        // 移除之前 pred -> predNext -> ... -> node自己 -> next
        // 移除之后 pred -> next
        Node predNext = pred.next;

        // Can use unconditional write instead of CAS here.
        // After this atomic step, other Nodes can skip past us.
        // Before, we are free of interference from other threads.
        // 无条件把自己设为 取消
        // 这个操作完成之后，其他的节点就会跳过我
        // 以前，我们不受其他线程的干扰。？？？？为什么是 before，应该也是 after 吧？
        node.waitStatus = Node.CANCELLED;

        // If we are the tail, remove ourselves.
        // 如果我是尾巴，那就简单了
        // 移除之前 pred -> predNext -> ... -> node自己 -> null
        // 移除之后 pred -> null
        if (node == tail && compareAndSetTail(node, pred)) {
            // 这个 CSA 没有自选
            // 因为前面说了：predNext变量是显而易见需要被取消胶接的，否则下面的CAS方法就会失败
            // ：
            pred.compareAndSetNext(predNext, null);

            // 如果 node 是尾巴，方法在这里旧结束了

        } else // 可惜不是尾巴呢，说明我有后继
        {
            // If successor needs signal, try to set pred's next-link
            // so it will get one. Otherwise wake it up to propagate.
            // 如果后继需要信号，那么把它设置为pred's next-link。
            // 否则直接唤醒它（唤醒 就是 传播？）
            int ws;


            // 如果 pred 不是 head，且
            // pred 需要信号 （且 pred.ws 就是 SIGNAL，或者可以设为 SIGNAL）
            // pred 内部 thread 非空
            if (pred != head &&
                    ((ws = pred.waitStatus) == Node.SIGNAL ||
                            (ws <= 0 && pred.compareAndSetWaitStatus(ws, Node.SIGNAL))) &&
                    pred.thread != null) {
                Node next = node.next;
                if (next != null && next.waitStatus <= 0)

                    // 进入这个 CAS 还需要判断 node.next 必须非空，且需要信号
                    // 这个操作不需要成功。如果成功，则
                    // 移除之前 pred -> predNext -> ... -> node自己 -> next
                    // 移除之后 pred -> next
                    // 把node和前面的不要信号的，踢出队列
                    pred.compareAndSetNext(predNext, next);
            } else {

                // 进入这里有以下几种条件中任意一个
                // 1. pred 是 head 头节点（头节点到底是什么？）
                // 2. pred 不需要信号（pred.ws > 0）
                // 3  pred 需要信号，但是 ws 不是 SIGNAL，且莫名其妙的通过 CAS 设为 SIGNAL 成功了
                // 4. pred 内的 thread 莫名其妙是 null

                // 前面的一通操作失败了，那我就把我后面的人叫醒
                unparkSuccessor(node);
            }


            // 如果不是尾巴，那就 node.next = node;

            // 好吧，怪不得 next 指针不靠谱
            // 在 unparkSuccessor(Node node) 中，如果 next 为空，或者后继不需要信号
            // 那就从尾巴往前找一个 需要唤醒的 。这种神奇的操作，根源大概在这个
            node.next = node; // help GC
        }
    }

    /**
     * Checks and updates status for a node that failed to acquire.
     * Returns true if thread should block. This is the main signal
     * control in all acquire loops.  Requires that pred == node.prev.
     * 是不是需要 park 在一次失败的 acquire 之后
     * 首先这是一个静态方法
     *
     * 我看了看。应该必有 node.thread == Thread.currentThread()
     *
     * |||||||| 核心代码 return pred.ws==SIGNAL ||||||||||| 其他都是额外的小事
     *
     * 首先 node 尝试 acquire 获取，但是失败了
     * 照道理来说，自己 node 当然要 park 了，以免浪费资源
     * 但是 node 需要先判断自己前面的人 pred 是不是 ws == SIGNAL，如果是的，那么说明 pred 有义务唤醒后继，后继是谁？就是 node
     * 所以此时 node 可以安心的 park，所以返回 true
     *
     * 但是，只要不是 pred.ws==SIGNAL，则一定返回 false
     * 返回 false 之前，node 还要做一点事
     * 第一件事 如果 pred.ws>0 那你给我滚吧，还呆在队伍里面干嘛？？
     * 第二件事 如果 pred.ws 是其他的负数，那就尝试一次 CAS 变成 SIGNAL
     *
     *
     * 其实 第二件事 我还没有弄懂，为什么动不动就可以把其他的人的 ws 变成 SIGNAL（前提是 ws是负数）
     * 那么 其他的负数 ws 没有意义了吗？
     *
     *
     * @param pred node's predecessor holding status
     * @param node the node
     * @return {@code true} if thread should block
     */
    private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
        /**
         * 为什么要传入 pred？
         * 单独传入 node，然后用 node.pred 去哪前驱不好吗？
         * 我仔细的看了下，pred 是这么来的
         * ---- 1. node = addWaiter(Node.SHARED or Node.EXCLUSIVE)
         * ---- 2. pred = node.pred
         * ---- 3. 然后 node 尝试 acquire，失败了就会调用这个方法
         *
         * 很明显，如果 1/2 步之间又有新的人加入队列的话，那么传入的 pred，肯定不等于 node.pred
         * 所以有可能是 pred -> 。。 -> node
         * 但是 pred 肯定排在 node 前面，这点应该不会有问题。
         *
         */


        int ws = pred.waitStatus;

        // 查看 pred.ws
        if (ws == Node.SIGNAL)
            /*
             * This node has already set status asking a release
             * to signal it, so it can safely park.
             * 只有到 pred.ws 是 SIGNAL 时，才能放心的 park
             */
            return true;

        // 其他的情况，只是做些额外的事情
        // 事情做玩，总是返回 false
        if (ws > 0) {
            /*
             * Predecessor was cancelled. Skip over predecessors and
             * indicate retry.
             * 前驱已经被取消了
             * 那给我滚蛋
             */
            do {
                node.prev = pred = pred.prev;
            } while (pred.waitStatus > 0);
            pred.next = node;
        } else {
            /*
             * waitStatus must be 0 or PROPAGATE.  Indicate that we
             * need a signal, but don't park yet.  Caller will need to
             * retry to make sure it cannot acquire before parking.
             * ws 是 0 或者是 PROPAGATE
             * 那就试一试把他改成 SIGNAL
             */
            pred.compareAndSetWaitStatus(ws, Node.SIGNAL);
        }

        // 做了小事后，返回 false
        // 说明 node 还想做一次 acquire
        // 失败了的话，再进来溜达溜达
        return false;
    }

    /**
     * Convenience method to interrupt current thread.
     * 给自己发中断信号
     */
    static void selfInterrupt() {
        Thread.currentThread().interrupt();
    }

    /**
     * Convenience method to park and then check if interrupted.
     * park 自己，醒来后返回自己是不是有中断标记
     *
     * @return {@code true} if interrupted
     */
    private final boolean parkAndCheckInterrupt() {
        LockSupport.park(this);
        // 注意这个方法检查了中断位后，会把去除中断标记
        return Thread.interrupted();
    }


    /*
     * Various flavors of acquire, varying in exclusive/shared and
     * control modes.  Each is mostly the same, but annoyingly
     * different.  Only a little bit of factoring is possible due to
     * interactions of exception mechanics (including ensuring that we
     * cancel if tryAcquire throws exception) and other control, at
     * least not without hurting performance too much.
     * 各种味道的 acquire 方法，独占模式、共享模式...
     * 主要不通之处在于和异常机制的交互
     * 比如说可以在 try acquire 失败后 cancel 取消
     * 不会太影响性能
     */

    /**
     * Acquires in exclusive uninterruptible mode for thread already in
     * queue. Used by condition wait methods as well as acquire.
     * 独占模式、不可打断的 acquire
     * thread 已经在队伍中了？//是吗？ 是的！！
     * 用于条件等待 和 acquire
     *
     * @param node the node
     * @param arg the acquire argument
     * @return {@code true} if interrupted while waiting // 如果在 等待中被打断了，返回 true
     */
    final boolean acquireQueued(final Node node, int arg) {
        // node 一般来自 addWaiter(Node.EXCLUSIVE)
        // 所以执行方法的线程 ，就是 node.thread (assert node.thread == Thread.currentThread();)

        boolean interrupted = false;
        try {
            for (; ; ) {

                // 即等于 p = node.prev ，但是判空
                final Node p = node.predecessor(); // throw new NullPointerException();

                if (p == head && // p 是头
                        // 为什么需要是头？ 因为只有自己的前驱是头的时候，才说明下一个执行的人是我


                        // 需要重写的方法，一般核心是 return compareAndSetState(0, acquires)
                        // 最简单的实现：
                        //                tryAcquire(arg)  ：
                        //        // *       if (compareAndSetState(0, 1)) {
                        //        // *         setExclusiveOwnerThread(Thread.currentThread());
                        //        // *         return true;
                        //        // *       }
                        //        // *       return false;
                        tryAcquire(arg) // 自己是排第一个了，还是得竞争啊，可怜啊，还有插队的
                ) {
                    // 自己变成头
                    setHead(node);
                    p.next = null; // help GC


                    return interrupted; // 这里的 interrupted 仅仅是给别人看排队中有没有被打断过，因为 parkAndCheckInterrupt 会移除中断标记
                }
                if (shouldParkAfterFailedAcquire(p, node)) // 是否需要 park ，这里面会踢人!!!!
                    interrupted |= parkAndCheckInterrupt(); // 需要则 park
                // ········  注意 parkAndCheckInterrupt() ，这个方法内部是 park(); return Thread.interrupted();
                // 即 park 被唤醒后，会检查中断位，内部调用的是 interrupted，因此会去除中断标记
            }

            // 问题：这里能 catch 到哪些异常？
            // 第一个 node.predecessor(); 抛出 NullPointerException ，表示这个节点没有前驱。这简直是不可能的事情
            // 第二个 tryAcquire(arg) 被写后，可以抛出任何运行期异常，在哪个方法注释中，一般推荐是 IllegalMonitorStateException
            // 最后 tryAcquire 没有被重写，抛出 UnsupportedOperationException
        } catch (Throwable t) {
            // node 踢出队列
            // 等等，需要踢出队列，潜台词是，node已经在队伍中了
            cancelAcquire(node);
            if (interrupted)
                // 又打断？
                // 答：是的，因为 interrupted == true ，意味着 parkAndCheckInterrupt() 返回了 true
                // 而 parkAndCheckInterrupt 方法检查中断位用的是 interrupted，会移除中断标记
                // 重新打标记
                selfInterrupt();

            // 异常抛出去
            throw t; // NullPointerException  IllegalMonitorStateException  UnsupportedOperationException
        }
    }

    /**
     * Acquires in exclusive interruptible mode.
     * 独占模型、可被中断的 acquired
     * @param arg the acquire argument
     */
    private void doAcquireInterruptibly(int arg)
            throws InterruptedException {
        // 在这里建立node节点
        // node.thread = curThread
        final Node node = addWaiter(Node.EXCLUSIVE); // 加到队尾

        try {
            for (; ; ) {
                final Node p = node.predecessor(); // p = node.prev

                if (p == head && // p=头，意味着我排第一个了 !!!!
                        tryAcquire(arg) // 但是还得和插队的人竞争，哭哭
                ) {
                    setHead(node);
                    p.next = null; // help GC
                    return;
                }

                // 真每秒啊
                if (shouldParkAfterFailedAcquire(p, node) // 需要 park 就执行 parkAndCheckInterrupt ，不需要就 继续循环
                        && parkAndCheckInterrupt()) // park 自己，检查中断位

                    throw new InterruptedException(); // 到了这里，说明 两个方法返回都是 true，说明有中断信号，抛出异常！！！
            }
        } catch (Throwable t) {
            // 自己滚出去
            cancelAcquire(node);
            throw t;
        }
    }

    /**
     * Acquires in exclusive timed mode.
     *
     * @param arg the acquire argument
     * @param nanosTimeout max wait time
     * @return {@code true} if acquired
     */
    private boolean doAcquireNanos(int arg, long nanosTimeout)
            throws InterruptedException {
        if (nanosTimeout <= 0L)
            return false;

        final long deadline = System.nanoTime() + nanosTimeout; // 死期

        final Node node = addWaiter(Node.EXCLUSIVE); // 哇哇

        try {
            for (; ; ) {

                final Node p = node.predecessor(); // p = node.prev

                if (p == head &&
                        tryAcquire(arg)) {
                    setHead(node);
                    p.next = null; // help GC
                    return true;
                }

                nanosTimeout = deadline - System.nanoTime(); // 剩余可用时间

                if (nanosTimeout <= 0L) {
                    // 滚出去吧
                    cancelAcquire(node);
                    return false;
                }

                if (shouldParkAfterFailedAcquire(p, node) &&
                        nanosTimeout > SPIN_FOR_TIMEOUT_THRESHOLD) // 终于看到这个常量了，美妙啊
                    // 只有剩余时间大于 SPIN_FOR_TIMEOUT_THRESHOLD（1ms） 才会使用 park

                    LockSupport.parkNanos(this, nanosTimeout); // 我就只 park 这么久

                // 最后这里检查 中断，而不是 parkAndCheckInterrupt ，垃圾
                if (Thread.interrupted())
                    throw new InterruptedException();
            }
        } catch (Throwable t) {
            // 滚吧
            cancelAcquire(node);
            throw t;
        }
    }

    /**
     * Acquires in shared uninterruptible mode.
     * @param arg the acquire argument
     */
    private void doAcquireShared(int arg) {
        final Node node = addWaiter(Node.SHARED);
        boolean interrupted = false;
        try {
            for (; ; ) {
                final Node p = node.predecessor();
                if (p == head) {
                    int r = tryAcquireShared(arg); // 这就是抢东西啊
                    if (r >= 0) {
                        setHeadAndPropagate(node, r); // 哇哇哇哇
                        p.next = null; // help GC
                        return;
                    }
                }
                if (shouldParkAfterFailedAcquire(p, node))
                    interrupted |= parkAndCheckInterrupt();
            }
        } catch (Throwable t) {
            cancelAcquire(node);
            throw t;
        } finally {
            if (interrupted)
                selfInterrupt();
        }
    }

    /**
     * Acquires in shared interruptible mode.
     * @param arg the acquire argument
     */
    private void doAcquireSharedInterruptibly(int arg) // 已阅
            throws InterruptedException {
        final Node node = addWaiter(Node.SHARED);
        try {
            for (; ; ) {
                final Node p = node.predecessor();
                if (p == head) {
                    int r = tryAcquireShared(arg);
                    if (r >= 0) {
                        setHeadAndPropagate(node, r);
                        p.next = null; // help GC
                        return;
                    }
                }
                if (shouldParkAfterFailedAcquire(p, node) &&
                        parkAndCheckInterrupt())
                    throw new InterruptedException();
            }
        } catch (Throwable t) {
            cancelAcquire(node);
            throw t;
        }
    }

    /**
     * Acquires in shared timed mode.
     *
     * @param arg the acquire argument
     * @param nanosTimeout max wait time
     * @return {@code true} if acquired
     */
    private boolean doAcquireSharedNanos(int arg, long nanosTimeout) // 已阅
            throws InterruptedException {
        if (nanosTimeout <= 0L)
            return false;
        final long deadline = System.nanoTime() + nanosTimeout;
        final Node node = addWaiter(Node.SHARED);
        try {
            for (; ; ) {
                final Node p = node.predecessor();
                if (p == head) {
                    int r = tryAcquireShared(arg);
                    if (r >= 0) {
                        setHeadAndPropagate(node, r);
                        p.next = null; // help GC
                        return true;
                    }
                }
                nanosTimeout = deadline - System.nanoTime();
                if (nanosTimeout <= 0L) {
                    cancelAcquire(node);
                    return false;
                }
                if (shouldParkAfterFailedAcquire(p, node) &&
                        nanosTimeout > SPIN_FOR_TIMEOUT_THRESHOLD)
                    LockSupport.parkNanos(this, nanosTimeout);
                if (Thread.interrupted())
                    throw new InterruptedException();
            }
        } catch (Throwable t) {
            cancelAcquire(node);
            throw t;
        }
    }

    // Main exported methods

    /**
     * Attempts to acquire in exclusive mode. This method should query
     * if the state of the object permits it to be acquired in the
     * exclusive mode, and if so to acquire it.
     * 尝试以独占模式 acquire
     * 这个方法需要检查 state 的状态
     * 如果允许 acquire，则执行 acquire
     *
     * <p>This method is always invoked by the thread performing
     * acquire.  If this method reports failure, the acquire method
     * may queue the thread, if it is not already queued, until it is
     * signalled by a release from some other thread. This can be used
     * to implement method {@link Lock#tryLock()}.
     * 这个方法的调用者必须是进行 acquire 操作的线程
     * 如果这个方法返回 false，在这个方法中，有可能 当前线程 会被加入队列中
     * 这样，当有另一个线程执行 release 时，当前线程会被 signalled （唤醒）
     * 这个方法，可以用于  {@link Lock#tryLock()}.
     *
     * <p>The default
     * implementation throws {@link UnsupportedOperationException}.
     * 默认实现抛出  {@link UnsupportedOperationException}.
     *
     * @param arg the acquire argument. This value is always the one
     *        passed to an acquire method, or is the value saved on entry
     *        to a condition wait.  The value is otherwise uninterpreted
     *        and can represent anything you like.
     *            acquire 的参数
     *            它的值总是 1 到传递到 acquired 模式
     *            或者是任意值，用于存在到 条件等待的 项 entry 中
     *            这个值在本类中未作更多解释
     * @return {@code true} if successful. Upon success, this object has
     *         been acquired.
     *         返回 true，则本对象（this），就被 acquired 了
     * @throws IllegalMonitorStateException if acquiring would place this
     *         synchronizer in an illegal state. This exception must be
     *         thrown in a consistent fashion for synchronization to work
     *         correctly.
     *         我看了下，一般这个异常出现在 tryRelease 中，主要是执行 tryRelease 的线程 和当前占用监控器的线程不一致时，抛出
     * @throws UnsupportedOperationException if exclusive mode is not supported
     * ········此异常表示不支持独占模式
     * @see MyAbstractQueuedSynchronizer#compareAndSetState(int, int)
     * ········内部一般调用此方法，try CAS 一下，执行成功，就会返回false
     * ········此方法不阻塞
     */
    protected boolean tryAcquire(int arg) {
        // 最简单的重写方法
        // *     public boolean tryAcquire(int acquires) {
        // *       assert acquires == 1; // Otherwise unused
        // *       if (compareAndSetState(0, 1)) {
        // *         setExclusiveOwnerThread(Thread.currentThread());
        // *         return true;
        // *       }
        // *       return false;
        // *     }

        //   MyAbstractQueuedSynchronizer#compareAndSetState(int, int)
        //protected final boolean compareAndSetState(int expect, int update) {
        //        return STATE.compareAndSet(this, expect, update);
        //    }
        throw new UnsupportedOperationException();
    }

    /**
     * Attempts to set the state to reflect a release in exclusive
     * mode.
     * 尝试设置 state 以反映独占模式下的 release
     *
     * <p>This method is always invoked by the thread performing release.
     * 这个方法总是由 执行 release 的线程调用!!
     * 如果不是，当然 IllegalMonitorStateException 警告
     *
     * <p>The default implementation throws
     * {@link UnsupportedOperationException}.
     *
     * @param arg the release argument. This value is always the one
     *        passed to a release method, or the current state value upon
     *        entry to a condition wait.  The value is otherwise
     *        uninterpreted and can represent anything you like.
     * @return {@code true} if this object is now in a fully released
     *         state, so that any waiting threads may attempt to acquire;
     *         and {@code false} otherwise.
     * @throws IllegalMonitorStateException if releasing would place this
     *         synchronizer in an illegal state. This exception must be
     *         thrown in a consistent fashion for synchronization to work
     *         correctly.
     * @throws UnsupportedOperationException if exclusive mode is not supported
     */
    protected boolean tryRelease(int arg) {
        // 核心 setState(0);

        // 最简单的实现
        // *     protected boolean tryRelease(int releases) {
        // *       assert releases == 1; // Otherwise unused
        // *       if (!isHeldExclusively())
        // *         throw new IllegalMonitorStateException();
        // *       setExclusiveOwnerThread(null);
        // *       setState(0);
        // *       return true;
        // *     }


        // 可重入锁中的实现
        //int c = getState() - releases;
        //            if (Thread.currentThread() != getExclusiveOwnerThread())
        //                throw new IllegalMonitorStateException();
        //            boolean free = false;
        //            if (c == 0) {
        //                free = true;
        //                setExclusiveOwnerThread(null);
        //            }
        //            setState(c);
        //            return free;

        throw new UnsupportedOperationException();
    }

    /**
     * Attempts to acquire in shared mode. This method should query if
     * the state of the object permits it to be acquired in the shared
     * mode, and if so to acquire it.
     *
     * <p>This method is always invoked by the thread performing
     * acquire.  If this method reports failure, the acquire method
     * may queue the thread, if it is not already queued, until it is
     * signalled by a release from some other thread.
     *
     * <p>The default implementation throws {@link
     * UnsupportedOperationException}.
     *
     * @param arg the acquire argument. This value is always the one
     *        passed to an acquire method, or is the value saved on entry
     *        to a condition wait.  The value is otherwise uninterpreted
     *        and can represent anything you like.
     * @return a negative value on failure; zero if acquisition in shared
     *         mode succeeded but no subsequent shared-mode acquire can
     *         succeed; and a positive value if acquisition in shared
     *         mode succeeded and subsequent shared-mode acquires might
     *         also succeed, in which case a subsequent waiting thread
     *         must check availability. (Support for three different
     *         return values enables this method to be used in contexts
     *         where acquires only sometimes act exclusively.)  Upon
     *         success, this object has been acquired.
     * @throws IllegalMonitorStateException if acquiring would place this
     *         synchronizer in an illegal state. This exception must be
     *         thrown in a consistent fashion for synchronization to work
     *         correctly.
     * @throws UnsupportedOperationException if shared mode is not supported
     */
    protected int tryAcquireShared(int arg) {
        throw new UnsupportedOperationException();
    }

    /**
     * Attempts to set the state to reflect a release in shared mode.
     *
     * <p>This method is always invoked by the thread performing release.
     *
     * <p>The default implementation throws
     * {@link UnsupportedOperationException}.
     *
     * @param arg the release argument. This value is always the one
     *        passed to a release method, or the current state value upon
     *        entry to a condition wait.  The value is otherwise
     *        uninterpreted and can represent anything you like.
     * @return {@code true} if this release of shared mode may permit a
     *         waiting acquire (shared or exclusive) to succeed; and
     *         {@code false} otherwise
     * @throws IllegalMonitorStateException if releasing would place this
     *         synchronizer in an illegal state. This exception must be
     *         thrown in a consistent fashion for synchronization to work
     *         correctly.
     * @throws UnsupportedOperationException if shared mode is not supported
     */
    protected boolean tryReleaseShared(int arg) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns {@code true} if synchronization is held exclusively with
     * respect to the current (calling) thread.  This method is invoked
     * upon each call to a {@link AbstractQueuedSynchronizer.ConditionObject} method.
     * 当前 this 对象，是不是由当前线程独占
     *
     * <p>The default implementation throws {@link
     * UnsupportedOperationException}. This method is invoked
     * internally only within {@link AbstractQueuedSynchronizer.ConditionObject} methods, so need
     * not be defined if conditions are not used.
     *
     * @return {@code true} if synchronization is held exclusively;
     *         {@code false} otherwise
     * @throws UnsupportedOperationException if conditions are not supported
     */
    protected boolean isHeldExclusively() {

        // 最简单实现
        // *     public boolean isHeldExclusively() {
        // *       // a data race, but safe due to out-of-thin-air guarantees
        // *       return getExclusiveOwnerThread() == Thread.currentThread();
        // *     }

        // 可重入锁，实现
        //protected final boolean isHeldExclusively() {
        //            // While we must in general read state before owner,
        //            // we don't need to do so to check if current thread is owner
        //            return getExclusiveOwnerThread() == Thread.currentThread();
        //        }


        throw new UnsupportedOperationException();
    }

    /**
     * Acquires in exclusive mode, ignoring interrupts.  Implemented
     * by invoking at least once {@link #tryAcquire},
     * returning on success.  Otherwise the thread is queued, possibly
     * repeatedly blocking and unblocking, invoking {@link
     * #tryAcquire} until success.  This method can be used
     * to implement method {@link Lock#lock}.
     * 独占模式的 acquire ，忽略中断
     * 会至少执行一次 tryAcquire （没错!!! acquireQueued ）
     *
     * @param arg the acquire argument.  This value is conveyed to
     *        {@link #tryAcquire} but is otherwise uninterpreted and
     *        can represent anything you like.
     */
    public final void acquire(int arg) {
        if (!tryAcquire(arg) && // 不排队，直接抢
                acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
            selfInterrupt(); // 为了重新标记

        // 情况一：
        // tryAcquire(arg) 返回 true，则线程 acquire 当前对象 this 成功（内部 cas state 成功）
        // 这时短路，acquireQueued 和 addWaiter 都不会执行，说明人没进入队列，但是 acquire 到了 this
        // acquireQueued 就不会执行，selfInterrupt() 也不会执行（不会给自己打中断信号）

        // 情况二：
        // tryAcquire 返回false，即线程 acquire 当前对象 this 失败（内部 cas state 失败）
        // 首先执行 addWaiter(Node.EXCLUSIVE), arg)
        // ···· 这个方法，会新建一个 node，node.thread = curThread
        // ···· 然后通过 cas 把 node 加入队尾（一定成功）
        // ···· addWaiter 返回 新建的 node，其中 node.thread = curThread
        // 然后执行 acquireQueued(newNode, arg) ,**这个方法是阻塞方法**
        // acquireQueued 等等返回值，表示 当前线程 or newNode 在等待 acquire 的过程中，是否被打断过
        // 但因为 检查是否被打断的方法是 interrupted 会清除中断标志位
        // 所以 acquireQueued 返回 true，则执行 selfInterrupt(); 中心标记
        // 否则 不执行，方法返回，线程独占 this 成功

        // 因此，tryAcquire 相当于不公平
    }

    /**
     * Acquires in exclusive mode, aborting if interrupted.
     * Implemented by first checking interrupt status, then invoking
     * at least once {@link #tryAcquire}, returning on
     * success.  Otherwise the thread is queued, possibly repeatedly
     * blocking and unblocking, invoking {@link #tryAcquire}
     * until success or the thread is interrupted.  This method can be
     * used to implement method {@link Lock#lockInterruptibly}.
     *
     * @param arg the acquire argument.  This value is conveyed to
     *        {@link #tryAcquire} but is otherwise uninterpreted and
     *        can represent anything you like.
     * @throws InterruptedException if the current thread is interrupted
     */
    public final void acquireInterruptibly(int arg)
            throws InterruptedException {
        if (Thread.interrupted())
            throw new InterruptedException();
        if (!tryAcquire(arg))
            doAcquireInterruptibly(arg);
    }

    /**
     * Attempts to acquire in exclusive mode, aborting if interrupted,
     * and failing if the given timeout elapses.  Implemented by first
     * checking interrupt status, then invoking at least once {@link
     * #tryAcquire}, returning on success.  Otherwise, the thread is
     * queued, possibly repeatedly blocking and unblocking, invoking
     * {@link #tryAcquire} until success or the thread is interrupted
     * or the timeout elapses.  This method can be used to implement
     * method {@link Lock#tryLock(long, TimeUnit)}.
     *
     * @param arg the acquire argument.  This value is conveyed to
     *        {@link #tryAcquire} but is otherwise uninterpreted and
     *        can represent anything you like.
     * @param nanosTimeout the maximum number of nanoseconds to wait
     * @return {@code true} if acquired; {@code false} if timed out
     * @throws InterruptedException if the current thread is interrupted
     */
    public final boolean tryAcquireNanos(int arg, long nanosTimeout)
            throws InterruptedException {
        if (Thread.interrupted())
            throw new InterruptedException();
        return tryAcquire(arg) ||
                doAcquireNanos(arg, nanosTimeout);
    }

    /**
     * Releases in exclusive mode.  Implemented by unblocking one or
     * more threads if {@link #tryRelease} returns true.
     * This method can be used to implement method {@link Lock#unlock}.
     *
     * @param arg the release argument.  This value is conveyed to
     *        {@link #tryRelease} but is otherwise uninterpreted and
     *        can represent anything you like.
     * @return the value returned from {@link #tryRelease}
     */
    public final boolean release(int arg) {
        if (tryRelease(arg)) {
            //tryRelease 方法一定返回 true （否则异常）
            Node h = head;
            if (h != null && h.waitStatus != 0)
                unparkSuccessor(h);
            return true;
        }
        return false;
    }

    /**
     * Acquires in shared mode, ignoring interrupts.  Implemented by
     * first invoking at least once {@link #tryAcquireShared},
     * returning on success.  Otherwise the thread is queued, possibly
     * repeatedly blocking and unblocking, invoking {@link
     * #tryAcquireShared} until success.
     *
     * @param arg the acquire argument.  This value is conveyed to
     *        {@link #tryAcquireShared} but is otherwise uninterpreted
     *        and can represent anything you like.
     */
    public final void acquireShared(int arg) {
        if (tryAcquireShared(arg) < 0)
            doAcquireShared(arg);
    }

    /**
     * Acquires in shared mode, aborting if interrupted.  Implemented
     * by first checking interrupt status, then invoking at least once
     * {@link #tryAcquireShared}, returning on success.  Otherwise the
     * thread is queued, possibly repeatedly blocking and unblocking,
     * invoking {@link #tryAcquireShared} until success or the thread
     * is interrupted.
     * @param arg the acquire argument.
     * This value is conveyed to {@link #tryAcquireShared} but is
     * otherwise uninterpreted and can represent anything
     * you like.
     * @throws InterruptedException if the current thread is interrupted
     */
    public final void acquireSharedInterruptibly(int arg)
            throws InterruptedException {
        if (Thread.interrupted())
            throw new InterruptedException();
        if (tryAcquireShared(arg) < 0)
            doAcquireSharedInterruptibly(arg);
    }

    /**
     * Attempts to acquire in shared mode, aborting if interrupted, and
     * failing if the given timeout elapses.  Implemented by first
     * checking interrupt status, then invoking at least once {@link
     * #tryAcquireShared}, returning on success.  Otherwise, the
     * thread is queued, possibly repeatedly blocking and unblocking,
     * invoking {@link #tryAcquireShared} until success or the thread
     * is interrupted or the timeout elapses.
     *
     * @param arg the acquire argument.  This value is conveyed to
     *        {@link #tryAcquireShared} but is otherwise uninterpreted
     *        and can represent anything you like.
     * @param nanosTimeout the maximum number of nanoseconds to wait
     * @return {@code true} if acquired; {@code false} if timed out
     * @throws InterruptedException if the current thread is interrupted
     */
    public final boolean tryAcquireSharedNanos(int arg, long nanosTimeout)
            throws InterruptedException {
        if (Thread.interrupted())
            throw new InterruptedException();
        return tryAcquireShared(arg) >= 0 ||
                doAcquireSharedNanos(arg, nanosTimeout);
    }

    /**
     * Releases in shared mode.  Implemented by unblocking one or more
     * threads if {@link #tryReleaseShared} returns true.
     *
     * @param arg the release argument.  This value is conveyed to
     *        {@link #tryReleaseShared} but is otherwise uninterpreted
     *        and can represent anything you like.
     * @return the value returned from {@link #tryReleaseShared}
     */
    public final boolean releaseShared(int arg) {
        if (tryReleaseShared(arg)) {
            doReleaseShared();
            return true;
        }
        return false;
    }

    // Queue inspection methods

    /**
     * Queries whether any threads are waiting to acquire. Note that
     * because cancellations due to interrupts and timeouts may occur
     * at any time, a {@code true} return does not guarantee that any
     * other thread will ever acquire.
     *
     * @return {@code true} if there may be other threads waiting to acquire
     */
    public final boolean hasQueuedThreads() {
        for (Node p = tail, h = head; p != h && p != null; p = p.prev)
            if (p.waitStatus <= 0)
                return true;
        return false;
    }

    /**
     * Queries whether any threads have ever contended to acquire this
     * synchronizer; that is, if an acquire method has ever blocked.
     *
     * <p>In this implementation, this operation returns in
     * constant time.
     *
     * @return {@code true} if there has ever been contention
     */
    public final boolean hasContended() {
        // 没错，太美妙了
        // 没有竞争的时候，队列就不会初始化
        return head != null;
    }

    /**
     * Returns the first (longest-waiting) thread in the queue, or
     * {@code null} if no threads are currently queued.
     *
     * <p>In this implementation, this operation normally returns in
     * constant time, but may iterate upon contention if other threads are
     * concurrently modifying the queue.
     *
     * @return the first (longest-waiting) thread in the queue, or
     *         {@code null} if no threads are currently queued
     */
    public final Thread getFirstQueuedThread() {
        // handle only fast path, else relay
        return (head == tail) ? null : fullGetFirstQueuedThread();
    }

    /**
     * Version of getFirstQueuedThread called when fastpath fails.
     */
    private Thread fullGetFirstQueuedThread() {
        /*
         * The first node is normally head.next. Try to get its
         * thread field, ensuring consistent reads: If thread
         * field is nulled out or s.prev is no longer head, then
         * some other thread(s) concurrently performed setHead in
         * between some of our reads. We try this twice before
         * resorting to traversal.
         */
        Node h, s;
        Thread st;

        // 这代码也真是强大啊

        if (((h = head) != null && (s = h.next) != null &&
                s.prev == head && (st = s.thread) != null) ||
                ((h = head) != null && (s = h.next) != null &&
                        s.prev == head && (st = s.thread) != null))
            return st;

        // 到这里了啊，竞争真剧烈

        /*
         * Head's next field might not have been set yet, or may have
         * been unset after setHead. So we must check to see if tail
         * is actually first node. If not, we continue on, safely
         * traversing from tail back to head to find first,
         * guaranteeing termination.
         */

        Thread firstThread = null;
        for (Node p = tail; p != null && p != head; p = p.prev) {
            Thread t = p.thread;
            if (t != null)
                firstThread = t;
        }
        return firstThread;
    }

    /**
     * Returns true if the given thread is currently queued.
     *
     * <p>This implementation traverses the queue to determine
     * presence of the given thread.
     *
     * @param thread the thread
     * @return {@code true} if the given thread is on the queue
     * @throws NullPointerException if the thread is null
     */
    public final boolean isQueued(Thread thread) {
        if (thread == null)
            throw new NullPointerException();
        for (Node p = tail; p != null; p = p.prev)
            if (p.thread == thread)
                return true;
        return false;
    }

    /**
     * Returns {@code true} if the apparent first queued thread, if one
     * exists, is waiting in exclusive mode.  If this method returns
     * {@code true}, and the current thread is attempting to acquire in
     * shared mode (that is, this method is invoked from {@link
     * #tryAcquireShared}) then it is guaranteed that the current thread
     * is not the first queued thread.  Used only as a heuristic in
     * ReentrantReadWriteLock.
     */
    final boolean apparentlyFirstQueuedIsExclusive() {
        Node h, s;
        return (h = head) != null &&
                (s = h.next) != null &&
                !s.isShared() &&
                s.thread != null;
    }

    /**
     * Queries whether any threads have been waiting to acquire longer
     * than the current thread.
     *
     * <p>An invocation of this method is equivalent to (but may be
     * more efficient than):
     * <pre> {@code
     * getFirstQueuedThread() != Thread.currentThread()
     *   && hasQueuedThreads()}</pre>
     *
     * <p>Note that because cancellations due to interrupts and
     * timeouts may occur at any time, a {@code true} return does not
     * guarantee that some other thread will acquire before the current
     * thread.  Likewise, it is possible for another thread to win a
     * race to enqueue after this method has returned {@code false},
     * due to the queue being empty.
     *
     * <p>This method is designed to be used by a fair synchronizer to
     * avoid <a href="AbstractQueuedSynchronizer.html#barging">barging</a>.
     * Such a synchronizer's {@link #tryAcquire} method should return
     * {@code false}, and its {@link #tryAcquireShared} method should
     * return a negative value, if this method returns {@code true}
     * (unless this is a reentrant acquire).  For example, the {@code
     * tryAcquire} method for a fair, reentrant, exclusive mode
     * synchronizer might look like this:
     *
     * <pre> {@code
     * protected boolean tryAcquire(int arg) {
     *   if (isHeldExclusively()) {
     *     // A reentrant acquire; increment hold count
     *     return true;
     *   } else if (hasQueuedPredecessors()) {
     *     return false;
     *   } else {
     *     // try to acquire normally
     *   }
     * }}</pre>
     *
     * @return {@code true} if there is a queued thread preceding the
     *         current thread, and {@code false} if the current thread
     *         is at the head of the queue or the queue is empty
     * @since 1.7
     */
    public final boolean hasQueuedPredecessors() {
        Node h, s;
        if ((h = head) != null) {
            if ((s = h.next) == null || s.waitStatus > 0) {
                s = null; // traverse in case of concurrent cancellation
                for (Node p = tail; p != h && p != null; p = p.prev) {
                    if (p.waitStatus <= 0)
                        s = p;
                }
            }
            if (s != null && s.thread != Thread.currentThread())
                return true;
        }
        return false;
    }

    // Instrumentation and monitoring methods

    /**
     * Returns an estimate of the number of threads waiting to
     * acquire.  The value is only an estimate because the number of
     * threads may change dynamically while this method traverses
     * internal data structures.  This method is designed for use in
     * monitoring system state, not for synchronization control.
     *
     * @return the estimated number of threads waiting to acquire
     */
    public final int getQueueLength() {
        int n = 0;
        for (Node p = tail; p != null; p = p.prev) {
            if (p.thread != null)
                ++n;
        }
        return n;
    }

    /**
     * Returns a collection containing threads that may be waiting to
     * acquire.  Because the actual set of threads may change
     * dynamically while constructing this result, the returned
     * collection is only a best-effort estimate.  The elements of the
     * returned collection are in no particular order.  This method is
     * designed to facilitate construction of subclasses that provide
     * more extensive monitoring facilities.
     *
     * @return the collection of threads
     */
    public final Collection<Thread> getQueuedThreads() {
        ArrayList<Thread> list = new ArrayList<>();
        for (Node p = tail; p != null; p = p.prev) {
            Thread t = p.thread;
            if (t != null)
                list.add(t);
        }
        return list;
    }

    /**
     * Returns a collection containing threads that may be waiting to
     * acquire in exclusive mode. This has the same properties
     * as {@link #getQueuedThreads} except that it only returns
     * those threads waiting due to an exclusive acquire.
     *
     * @return the collection of threads
     */
    public final Collection<Thread> getExclusiveQueuedThreads() {
        ArrayList<Thread> list = new ArrayList<>();
        for (Node p = tail; p != null; p = p.prev) {
            if (!p.isShared()) {
                Thread t = p.thread;
                if (t != null)
                    list.add(t);
            }
        }
        return list;
    }

    /**
     * Returns a collection containing threads that may be waiting to
     * acquire in shared mode. This has the same properties
     * as {@link #getQueuedThreads} except that it only returns
     * those threads waiting due to a shared acquire.
     *
     * @return the collection of threads
     */
    public final Collection<Thread> getSharedQueuedThreads() {
        ArrayList<Thread> list = new ArrayList<>();
        for (Node p = tail; p != null; p = p.prev) {
            if (p.isShared()) {
                Thread t = p.thread;
                if (t != null)
                    list.add(t);
            }
        }
        return list;
    }

    /**
     * Returns a string identifying this synchronizer, as well as its state.
     * The state, in brackets, includes the String {@code "State ="}
     * followed by the current value of {@link #getState}, and either
     * {@code "nonempty"} or {@code "empty"} depending on whether the
     * queue is empty.
     *
     * @return a string identifying this synchronizer, as well as its state
     */
    public String toString() {
        return super.toString()
                + "[State = " + getState() + ", "
                + (hasQueuedThreads() ? "non" : "") + "empty queue]";
    }


    /**
     *
     * 和 condition 相关的方法
     * 暂时略
     * JDK 13 LINE 1664 - 2298
     *
     *
     *
     *
     *
     *
     *
     *
     */


    // VarHandle mechanics
    private static final VarHandle STATE;
    private static final VarHandle HEAD;
    private static final VarHandle TAIL;

    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            STATE = l.findVarHandle(MyAbstractQueuedSynchronizer.class, "state", int.class);
            HEAD = l.findVarHandle(MyAbstractQueuedSynchronizer.class, "head", MyAbstractQueuedSynchronizer.Node.class);
            TAIL = l.findVarHandle(MyAbstractQueuedSynchronizer.class, "tail", MyAbstractQueuedSynchronizer.Node.class);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }

        // Reduce the risk of rare disastrous classloading in first call to
        // LockSupport.park: https://bugs.openjdk.java.net/browse/JDK-8074773
        Class<?> ensureLoaded = LockSupport.class;
    }

    /**
     * Initializes head and tail fields on first contention.
     * 初始化等待队列
     * 如果没有并发，那么就等于：
     * head = new Node();
     * tail = head;
     */
    private final void initializeSyncQueue() {
        Node h;
        if (HEAD.compareAndSet(this, null, (h = new Node())))
            tail = h;
    }

    /**
     * CASes tail field.
     * CAS 设置尾巴
     */
    private final boolean compareAndSetTail(Node expect, Node update) {
        return TAIL.compareAndSet(this, expect, update);
    }

}
