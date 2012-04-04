package org.pierrre.googleplayhelper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends Activity implements View.OnClickListener {
	private RadioGroup action;
	private EditText text;
	private Button open;
	private Button about;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.main);
		
		this.action = (RadioGroup) this.findViewById(R.id.action);
		this.text = (EditText) this.findViewById(R.id.text);
		this.open = (Button) this.findViewById(R.id.open);
		this.about = (Button) this.findViewById(R.id.about);
		
		this.open.setOnClickListener(this);
		this.about.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if (v == this.open) {
			String textValue = this.text.getText().toString();
			
			switch (this.action.getCheckedRadioButtonId()) {
			case R.id.details:
				GooglePlayHelper.details(this, textValue);
				break;
			case R.id.search:
				GooglePlayHelper.search(this, textValue);
				break;
			case R.id.publisher:
				GooglePlayHelper.publisher(this, textValue);
				break;
			}
		} else if (v == this.about) {
			Uri uri = Uri.parse(this.getString(R.string.website_url));
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			
			this.startActivity(intent);
		}
	}
}