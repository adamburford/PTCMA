package com.example.adam.ptcma;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.ListView;

public class Customers extends AppCompatActivity {

	private DBManager dbManager;

	private ListView listView;

	private android.support.v4.widget.SimpleCursorAdapter adapter;

	final String[] from = new String[] { DatabaseHelper._ID,
			DatabaseHelper.NAME, DatabaseHelper.PHONE, DatabaseHelper.EMAIL, DatabaseHelper.ADDRESS, DatabaseHelper.PICTURE };

	final int[] to = new int[] { R.id.id, R.id.customer_name, R.id.customer_phone, R.id.customer_email, R.id.customer_address, R.id.customer_picture };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customers);

		Button addCustomerButton = (Button) findViewById(R.id.addCustomerButton);
		addCustomerButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				addCustomer();
			}
		});

		Button viewCustomersButton = findViewById(R.id.viewAppointments);
		viewCustomersButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onViewAppointmentsButtonClicked();
			}
		});

		dbManager = new DBManager(this);
		dbManager.open();
		Cursor cursor = dbManager.fetch();

		ListView listView = (ListView)findViewById(R.id.customer_list);

		adapter = new android.support.v4.widget.SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
		adapter.notifyDataSetChanged();

		listView.setAdapter(adapter);

		/*
		// OnCLickListiner For List Items
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
				TextView idTextView = (TextView) view.findViewById(R.id.id);
				TextView titleTextView = (TextView) view.findViewById(R.id.title);
				TextView descTextView = (TextView) view.findViewById(R.id.desc);

				String id = idTextView.getText().toString();
				String title = titleTextView.getText().toString();
				String desc = descTextView.getText().toString();

				Intent modify_intent = new Intent(getApplicationContext(), ModifyCountryActivity.class);
				modify_intent.putExtra("title", title);
				modify_intent.putExtra("desc", desc);
				modify_intent.putExtra("id", id);

				startActivity(modify_intent);
			}
		});
		*/


	}

	void addCustomer() {

		Intent intent = new Intent(this, com.example.adam.ptcma.EditCustomerActivity.class);
		startActivity(intent);
	}

	void onViewAppointmentsButtonClicked() {
		Intent intent = new Intent(this, com.example.adam.ptcma.Appointments.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.logoff, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
		return true;
	}
}
