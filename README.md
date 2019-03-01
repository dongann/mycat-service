# mycat中间件实现分表分库
1.下载mycat 地址 http://dl.mycat.io/1.6.6.1/
2.配置mycat：schema.xml,rule.xml,server.xml,sequence_db_conf.properties
schema.xml
```
<?xml version="1.0"?>
<!DOCTYPE mycat:schema SYSTEM "schema.dtd">
<mycat:schema xmlns:mycat="http://io.mycat/">

    <schema name="TESTDB" checkSQLschema="false" sqlMaxLimit="100">
            <table name="cusers" primaryKey="cuserId" autoIncrement="true" dataNode="dn01,dn02" rule="rule1" />  
    </schema>
    
    <!-- 设置dataNode 对应的数据库,及 mycat 连接的地址dataHost -->  
    <dataNode name="dn01" dataHost="dh01" database="master" />  
    <dataNode name="dn02" dataHost="dh01" database="slave" />   
    
    <!-- mycat 逻辑主机dataHost对应的物理主机.其中也设置对应的mysql登陆信息 -->  
    <dataHost name="dh01" maxCon="1000000" minCon="1" balance="0" writeType="0" dbType="mysql" dbDriver="native">  
            <heartbeat>select user()</heartbeat>  
            <writeHost host="127.0.0.1" url="127.0.0.1:3306" user="root" password="000000"/>  
    </dataHost> 
</mycat:schema>
```
rule.xml:

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mycat:rule SYSTEM "rule.dtd">
<mycat:rule xmlns:mycat="http://io.mycat/">
    <tableRule name="rule1">
        <rule>
            <columns>cuserId</columns>
            <algorithm>mod-long</algorithm>
        </rule>
    </tableRule>
    <function name="mod-long" class="io.mycat.route.function.PartitionByMod">
        <!-- how many data nodes -->
        <property name="count">2</property>
    </function>
</mycat:rule>
```
server.xml:
```
<user name="root">
		<property name="password">000000</property>
		<property name="schemas">TESTDB</property>
		
		<!-- 表级 DML 权限设置 -->
		<!-- 		
		<privileges check="false">
			<schema name="TESTDB" dml="0110" >
				<table name="tb01" dml="0000"></table>
				<table name="tb02" dml="1111"></table>
			</schema>
		</privileges>		
		 -->
	</user>

	<user name="user">
		<property name="password">user</property>
		<property name="schemas">TESTDB</property>
		<property name="readOnly">true</property>
	</user>
```

```
<property name="sequnceHandlerType">1</property>
```
sequence_db_conf.properties:

```
GLOBAL=dn01
CUSERS=dn01
```
3.启动mycat
 `.文件目录/bin/mycat start` 启动
 `.文件目录/bin/mycat restart` 重新启动
 `.文件目录/bin/mycat stop` 关闭
 `.文件目录/bin/mycat console` 查看
4.在mysql创建两个数据库，master slave，分别创建一个cusers表
5.创建项目完成，分表分库
 
  