package com.valtech.training.dto;

public class BookInfoDTO {

		private String publisherName;
		private int price;
		
		public BookInfoDTO(String publisherName, int price) {
			this.publisherName = publisherName;
			this.price = price;
		}

		public String getPublisherName() {
			return publisherName;
		}

		public void setPublisherName(String publisherName) {
			this.publisherName = publisherName;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
		
		
		
		
	}





