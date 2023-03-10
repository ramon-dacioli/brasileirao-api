package com.devqualisys.brasileiraoapi.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devqualisys.brasileiraoapi.dto.PartidaGoogleDTO;

public class ScrapingUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScrapingUtil.class); 
	private static final String BASE_URL_GOOGLE = "https://www.google.com.br/search?q=";
	private static final String COMPLEMENTO_URL_GOOGLE = "&hl=pt-BR";

	public static void main(String[] args) {
		String url = BASE_URL_GOOGLE + "palmeiras+x+corintians+08/08/2020" + COMPLEMENTO_URL_GOOGLE;
		
		ScrapingUtil scraping = new ScrapingUtil();
		scraping.obtemInformacoesPartidas(url);
	}
	
	public PartidaGoogleDTO obtemInformacoesPartidas(String url) {
		
		PartidaGoogleDTO partida = new PartidaGoogleDTO();
		
		try {
			Document document = Jsoup.connect(url).get();
			
			String title = document.title();
			LOGGER.info("titulo da pagina: {}", title);
			
		} catch (IOException e) {
			LOGGER.error("ERRO AO TENTAR CONECTAR NO GOOGLE COM JSOUP - > {}", e.getMessage());
		}
		
		return partida;
	}

}
