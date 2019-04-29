#ZooKeeper（分布式协调服务）-CAP（CP）【2PC协议】
1.协议地址维护
2.负载均衡机制
3.服务上下线感知
##Zookeeper Installation
create  /orderservice/wsdl 1
create -e [ephemeral] /tmp  99
create -s [seq] /tmp 1

##ZooKeeper 特性

1.同一节点唯一性
2.二类节点：持久化节点，临时节点
3.有序节点、无序节点
4.临时节点不能创建子节点



