package com.zrx.fragment.concurrent.locks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.locks.LockSupport;

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
         * 或者很快将会被阻塞，为什么这里说“很快将”呢，有点难理解；
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
        Node(MyAbstractQueuedSynchronizer.Node nextWaiter) {
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
            // this.nextWaiter 就是传入的东西
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
     * TODO
     */
    private transient volatile MyAbstractQueuedSynchronizer.Node head;

    /**
     * Tail of the wait queue, lazily initialized.  Modified only via
     * method enq to add new wait node.
     */
    private transient volatile MyAbstractQueuedSynchronizer.Node tail;

    /**
     * The synchronization state.
     */
    private volatile int state;

    /**
     * Returns the current value of synchronization state.
     * This operation has memory semantics of a {@code volatile} read.
     * @return current state value
     */
    protected final int getState() {
        return state;
    }

    /**
     * Sets the value of synchronization state.
     * This operation has memory semantics of a {@code volatile} write.
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
     *
     * @param expect the expected value
     * @param update the new value
     * @return {@code true} if successful. False return indicates that the actual
     *         value was not equal to the expected value.
     */
    protected final boolean compareAndSetState(int expect, int update) {
        return STATE.compareAndSet(this, expect, update);
    }




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

}
