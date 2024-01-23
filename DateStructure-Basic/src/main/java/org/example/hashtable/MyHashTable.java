package org.example.hashtable;

/**
 * 一个简单散列表实现 hash表
 *
 * @author zhaoqw
 * @date 2022/09/19
 */
public class MyHashTable<K, V> {
    /**
     * 默认散列表长度
     */
    private static final int DEFAULT_INITAL_CAPACITY = 8;

    /**
     * 装载因子
     */
    private static final float LOAD_FACTOR = 0.75f;

    /**
     * 初始化散列表数组
     */
    private Entry<K, V>[] table;

    /**
     * 实际元素数量
     */
    private int size = 0;

    /**
     * 散列表索引数量
     */
    private int use = 0;

    public MyHashTable() {
        table = (Entry<K, V>[]) new Entry[DEFAULT_INITAL_CAPACITY];
    }

    static class Entry<K, V> {
        K key;
        V value;

        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }


    }


    /**
     * 新增
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int index = hash(key);

        // 位置未被引用
        if (table[index] == null) {
            table[index] = new Entry<>(null, null, null);
        }

        Entry<K, V> tmp = table[index];
        // 新增节点
        if (tmp.next == null) {
            tmp.next = new Entry<>(key, value, null);
            this.size++;
            use++;
            // 动态扩容
            if (use >= table.length * LOAD_FACTOR) {
                resize();
            }
            // 如果已经有数据存在，解决冲突
        } else {
            do {
                tmp = tmp.next;
                if (tmp.key == key) {
                    tmp.value = value;
                    return;
                }
            } while (tmp.next != null);
            Entry<K, V> temp = table[index].next;
            table[index].next = new Entry<>(key, value, temp);
            size++;
        }

    }

    /**
     * 删除
     *
     * @param key 键
     */
    public void remove(K key) {
        int index = hash(key);
        Entry e = table[index];
        if (e == null || e.next == null) {
            return;
        }

        Entry pre;
        Entry<K, V> headNode = table[index];
        do {
            pre = e;
            e = e.next;
            if (key == e.key) {
                pre.next = e.next;
                size--;
                if (headNode.next == null) use--;
                return;
            }
        } while (e.next != null);
    }

    /**
     * 获取
     *
     * @param key
     * @return
     */
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        if (entry == null || entry.next == null) {
            return null;
        }

        while (entry.next != null) {
            entry = entry.next;
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    /**
     * 扩容
     */
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = (Entry<K, V>[]) new Entry[table.length * 2];
        int use = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] == null || oldTable[i].next == null) {
                continue;
            }

            Entry<K, V> entry = oldTable[i];
            while (entry.next != null) {
                entry = entry.next;
                int index = hash(entry.key);
                if (table[index] == null) {
                    use++;
                    // 创建哨兵节点
                    table[index] = new Entry<>(null, null, null);
                }
                table[index].next = new Entry<>(entry.key, entry.value, table[index].next);
            }
        }
    }

    /**
     * 散列函数
     * <p>
     * 参考hashmap散列函数
     *
     * @param key
     * @return
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % table.length;
    }
}
