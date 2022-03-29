
### HashMapTest
---
해시맵의 키 부분에 객체를 집어넣을 경우에 대한 테스트
hashCode, equals를 오버라이드해서 강제로 같은 값을 나오게 하는 경우 새로운 객체를 생성하여 키로서 get 함수를 호출하는 경우 정상적으로 값을 가져오게된다. 단 동일한 value의 값이 존재한다면 마지막에 삽입한 값을 가져온다 이는 HashMap이 구현된 부분의 get 함수를 찾아보면 알 수 있다.  

```Java
public V get(Object key) {
    Node<K,V> e;
    return (e = getNode(key)) == null ? null : e.value;
}

final Node<K,V> getNode(Object key) {
    Node<K,V>[] tab; Node<K,V> first, e; int n, hash; K k;
    if ((tab = table) != null && (n = tab.length) > 0 &&
        (first = tab[(n - 1) & (hash = hash(key))]) != null) {
        if (first.hash == hash && // always check first node
            ((k = first.key) == key || (key != null && key.equals(k))))
            return first;
        if ((e = first.next) != null) {
            if (first instanceof TreeNode)
                return ((TreeNode<K,V>)first).getTreeNode(hash, key);
            do {
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    return e;
            } while ((e = e.next) != null);
        }
    }
    return null;
}
```
단, hashCode, equals 둘 다 오버라이드 하여 조작한 경우만 위 처럼 동작한다.

또한, 해시값의 경우 객체가 생성된 이후 객체 내의 값이 변경되어도 동일하다.
