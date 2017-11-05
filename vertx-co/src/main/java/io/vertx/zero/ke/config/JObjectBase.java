package io.vertx.zero.ke.config;

import com.vie.hoc.HPool;
import com.vie.util.Instance;
import io.vertx.core.json.JsonObject;
import io.vertx.zero.ke.ZeroNode;

public abstract class JObjectBase implements ZeroNode<JsonObject> {
    @Override
    public JsonObject read() {
        final ZeroNode<JsonObject> node
                = HPool.exec(Storage.NODES, getKey(),
                () -> Instance.instance(ZeroPlugin.class, getKey()));
        return node.read();
    }

    public abstract String getKey();
}
