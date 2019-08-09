package com.atob.intentdemo.ui

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.atob.intentdemo.R
import com.atob.intentdemo.model.Book
import kotlinx.android.synthetic.main.activity_book_details.*

class BookDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        btn_save_book.setOnClickListener {
            var intentSaveBook = Intent()
            intentSaveBook.putExtra("book", createBook())
            setResult(RESULT_OK, intentSaveBook)
            finish()
        }


        var bundle: Bundle? = intent.extras
        if (bundle != null) {
            loadBook(bundle!!.getSerializable("tvBook") as Book)
        }
    }

    fun loadBook(book: Book) {
        et_book_title.setText(book.title)
    }

    fun createBook(): Book {
        var newBook = Book(et_book_title.text.toString())
        return newBook
    }
}
