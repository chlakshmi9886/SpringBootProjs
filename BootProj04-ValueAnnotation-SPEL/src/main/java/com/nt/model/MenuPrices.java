package com.nt.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("menuprice")
@Data
public class MenuPrices {

	@Value("${menu.dosa}")
	private Float dosaPrice;
	@Value("${menu.idlyrate}")
	private Float idlyrate;
	@Value("${menu.poharate}")
	private Float pohaprice;
	@Value("${menu.vadapav}")
	private Float vadpavprice;
}
