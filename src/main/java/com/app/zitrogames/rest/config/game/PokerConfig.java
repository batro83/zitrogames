package com.app.zitrogames.rest.config.game;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "poker")
public class PokerConfig extends BaseGameConfig {}
