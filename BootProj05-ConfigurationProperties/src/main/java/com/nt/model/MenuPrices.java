package com.nt.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("menuprice")
@Data
@ConfigurationProperties(prefix="menu.rate")
public class MenuPrices {

	private Float idly;
	private Float dosa;
	private Float vadapav;
	private Float poha;
}
