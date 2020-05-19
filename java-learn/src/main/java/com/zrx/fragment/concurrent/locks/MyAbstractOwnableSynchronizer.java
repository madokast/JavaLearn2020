package com.zrx.fragment.concurrent.locks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * MyAbstractOwnableSynchronizer
 *
 *  * A synchronizer that may be exclusively owned by a thread.  This
 *  * class provides a basis for creating locks and related synchronizers
 *  * that may entail a notion of ownership.  The
 *  可以被一个线程独占的同步器，这是构造锁和相关的同步器的基础
 *  * {@code AbstractOwnableSynchronizer} class itself does not manage or
 *  * use this information. However, subclasses and tools may use
 *  * appropriately maintained values to help control and monitor access
 *  * and provide diagnostics.
 *  这个类，不管理、使用这些信息，而是子类使用合适的信息，用于控制、管理访问行为，提供诊断
 *  *
 *  * @since 1.6
 *  * @author Doug Lea
 *
 * <p>
 * Data
 * 2020/5/18-12:45
 *
 * @author zrx
 * @version 1.0
 */

public abstract class MyAbstractOwnableSynchronizer implements java.io.Serializable{
    private final static Logger LOGGER = LoggerFactory.getLogger(MyAbstractOwnableSynchronizer.class);

    /** Use serial ID even though all fields transient.
     * 使用序列化ID 虽然所有字段都是 transient 短暂的
     * volatile - 易变的
     * transient - 短暂的
     * */
    private static final long serialVersionUID = 3737899427754241961L;

    /**
     * Empty constructor for use by subclasses.
     * 给子类用的空构造器
     */
    protected MyAbstractOwnableSynchronizer() {
        LOGGER.info("init MyAbstractOwnableSynchronizer()");
    }

    /**
     * The current owner of exclusive mode synchronization.
     * 独占模式的同步器 的所有者
     * 即一个线程独占这个对象
     */
    private transient Thread exclusiveOwnerThread;

    /**
     * Sets the thread that currently owns exclusive access.
     * A {@code null} argument indicates that no thread owns access.
     * This method does not otherwise impose any synchronization or
     * {@code volatile} field accesses.
     * 设置当前进行独占访问的线程
     * 返回 null 表示没有线程进行访问
     * 这个方法不进行同步，访问的也不是 volatile 对象
     * 注意：这是个 final 对象
     * @param thread the owner thread
     */
    protected final void setExclusiveOwnerThread(Thread thread) {
        LOGGER.info("setExclusiveOwnerThread({})",thread);
        exclusiveOwnerThread = thread;
    }

    /**
     * Returns the thread last set by {@code setExclusiveOwnerThread},
     * or {@code null} if never set.  This method does not otherwise
     * impose any synchronization or {@code volatile} field accesses.
     * 返回由 setExclusiveOwnerThread 设置的线程，null 表示从未设置
     * 同样的，这个对象也不进行同步
     * @return the owner thread
     */
    protected final Thread getExclusiveOwnerThread() {
        LOGGER.info("getExclusiveOwnerThread()={}",exclusiveOwnerThread);
        return exclusiveOwnerThread;
    }
}
