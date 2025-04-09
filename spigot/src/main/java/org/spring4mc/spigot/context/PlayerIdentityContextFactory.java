package org.spring4mc.spigot.context;

import org.bukkit.entity.Player;
import org.spring4mc.context.BaseIdentityContext;
import org.spring4mc.context.BaseIdentityContextFactoryImpl;
import org.springframework.stereotype.Component;

@Component
public class PlayerIdentityContextFactory extends BaseIdentityContextFactoryImpl<Player> {

    public PlayerIdentityContextFactory() {
        super(BaseIdentityContext.class, Player.class);
    }
}
