package id.owndigital.mvpexamplekotlin

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import id.owndigital.mvpexamplekotlin.model.MainPresenterImp
import id.owndigital.mvpexamplekotlin.presenter.MainPresenter
import id.owndigital.mvpexamplekotlin.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    // var presenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init presenter
        presenter = MainPresenterImp(this)

        // event click listener pada btnAdd
        btnAdd.setOnClickListener {
            // memanggil method addData pada presenter
            presenter.addData(edFirstName.text.toString(),edLastName.text.toString())
        }

        // event click listener pada btnShow
        btnShow.setOnClickListener {
            // memanggil method loadData pada presenter
            presenter.loadData()
        }

    }

    // view menampilkan pesan toast
    override fun showMessage(message: String) {
        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
    }

    // view menampilkan data
    override fun showData(data: String) {

        // meanmpilkan data pada dialog
        AlertDialog.Builder(this)
                .setTitle("Data")
                .setMessage(data)
                .setPositiveButton("Close", DialogInterface.OnClickListener { dialogInterface, i ->
                    dialogInterface.dismiss()
                })
                .show()

    }

    // view utk clear edittext
    override fun clearField() {
        edFirstName.setText("")
        edLastName.setText("")
    }

}