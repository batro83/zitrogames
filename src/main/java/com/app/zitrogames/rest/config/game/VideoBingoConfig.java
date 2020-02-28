package com.app.zitrogames.rest.config.game;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "videobingo")
public class VideoBingoConfig extends BaseGameConfig {}
