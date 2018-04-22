package com.example.adam.ptcma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Appointments extends AppCompatActivity {

	private Button viewCustomersButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appointments);

		viewCustomersButton = findViewById(R.id.viewCustomers);
		viewCustomersButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onViewCustomersButtonClicked();
			}
		});
	}

	private void onViewCustomersButtonClicked() {
		Intent intent = new Intent(this, Customers.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.logoff, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(getApplicationContext(), "Logging you off", Toast.LENGTH_LONG).show();
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
		return true;
	}
}
