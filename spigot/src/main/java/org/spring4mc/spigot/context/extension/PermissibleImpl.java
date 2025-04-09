package org.spring4mc.spigot.context.extension;

import org.bukkit.entity.Player;
import org.spring4mc.context.IdentityContext;
import org.spring4mc.context.extension.Permissible;

public interface PermissibleImpl extends Permissible, IdentityContext<Player> {

    @Override
    default boolean hasPermission(String permission) {
        return this.target().hasPermission(permission);
    }
}
