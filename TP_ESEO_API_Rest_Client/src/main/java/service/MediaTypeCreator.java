package service;

import com.squareup.okhttp.MediaType;

public class MediaTypeCreator {
	public static MediaType createMediaType(String mediaType) {
		return MediaType.parse("application/json; charset=utf-8");
	}
}