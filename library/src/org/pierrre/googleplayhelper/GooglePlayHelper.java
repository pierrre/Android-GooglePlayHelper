package org.pierrre.googleplayhelper;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class GooglePlayHelper {
	private static final String URI_DETAILS_APP = "market://details?id=%1$s";
	private static final String URI_DETAILS_WEB = "http://play.google.com/store/apps/details?id=%1$s";
	private static final String URI_SEARCH_APP = "market://search?q=%1$s";
	private static final String URI_SEARCH_WEB = "http://play.google.com/store/search?q=%1$s";
	private static final String URI_PUBLISHER_APP = "market://search?q=pub:%1$s";
	private static final String URI_PUBLISHER_WEB = "http://play.google.com/store/search?q=pub:%1$s";
	
	public static void details(Context context, String packageName) {
		if (!GooglePlayHelper.open(context, GooglePlayHelper.URI_DETAILS_APP, packageName)) {
			GooglePlayHelper.open(context, GooglePlayHelper.URI_DETAILS_WEB, packageName);
		}
	}
	
	public static void search(Context context, String query) {
		if (!GooglePlayHelper.open(context, GooglePlayHelper.URI_SEARCH_APP, query)) {
			GooglePlayHelper.open(context, GooglePlayHelper.URI_SEARCH_WEB, query);
		}
	}
	
	public static void publisher(Context context, String publisherName) {
		if (!GooglePlayHelper.open(context, GooglePlayHelper.URI_PUBLISHER_APP, publisherName)) {
			GooglePlayHelper.open(context, GooglePlayHelper.URI_PUBLISHER_WEB, publisherName);
		}
	}
	
	private static boolean open(Context context, String uriModel, String value) {
		Uri uri = Uri.parse(String.format(uriModel, Uri.encode(value)));
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		
		try {
			context.startActivity(intent);
			
			return true;
		} catch (ActivityNotFoundException e) {
			return false;
		}
	}
}