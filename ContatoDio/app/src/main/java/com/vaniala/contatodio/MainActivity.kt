package com.vaniala.contatodio

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private val REQUEST_PERMISSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.READ_CONTACTS),
                REQUEST_PERMISSION
            )
        } else {
            setContacts()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (REQUEST_PERMISSION == requestCode) setContacts()
    }

    private fun setContacts() {

        val contactList: ArrayList<Contact> = ArrayList()

        val cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )
        if (cursor != null) {
            while (cursor.moveToNext()) {
                contactList.add(
                    Contact(
                        cursor.getString(
                            cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME),
                        ),
                        cursor.getString(
                            cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER),
                        )
                    )
                )
            }
            cursor.close()
        }

        val adapter = ContactAdapter(contactList)
        val contactRecyclerView = findViewById<RecyclerView>(R.id.recycler_contats)

        contactRecyclerView.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL, false)

        contactRecyclerView.adapter = adapter

    }
}