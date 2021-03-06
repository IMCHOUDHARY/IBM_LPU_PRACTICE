package com.example.anno.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component
public class Image {

	@Value("Img1")
	private String ImageId;
	@Value("Image.com")
	private String ImageUrl;
}
