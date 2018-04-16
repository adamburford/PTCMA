package com.example.adam.ptcma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditCustomerActivity extends AppCompatActivity implements View.OnClickListener {

	private Button saveButton;
	private EditText customerName;
	private EditText customerPhone;
	private EditText customerEmail;
	private EditText customerAddress;

	private DBManager dbManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_customer);

		customerName = (EditText) findViewById(R.id.editText2);
		customerPhone = (EditText) findViewById(R.id.editText3);
		customerEmail = (EditText) findViewById(R.id.editText4);
		customerAddress = (EditText) findViewById(R.id.editText5);

		saveButton = (Button) findViewById(R.id.button);

		dbManager = new DBManager(this);
		dbManager.open();
		saveButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.button:

				final String name = customerName.getText().toString();
				final String phone = customerPhone.getText().toString();
				final String email = customerEmail.getText().toString();
				final String address = customerAddress.getText().toString();

				dbManager.insert(name, phone, email, address);

				Intent intent = new Intent(this, Customers.class);
				startActivity(intent);
				break;
		}
	}
}
