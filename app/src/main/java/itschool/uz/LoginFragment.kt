package itschool.uz

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import itschool.uz.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var emailEdit: EditText
    private lateinit var passwordedit: EditText
    private lateinit var dbh:DBHelper
    private lateinit var kirishBtn :Button
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


kirishBtn.findViewById<Button>(R.id.kirish)
        emailEdit.findViewById<EditText>(R.id.email)
        passwordedit.findViewById<EditText>(R.id.parol)

        dbh = DBHelper(this)


        kirishBtn.setOnClickListener {
            val emailedtx= emailEdit.text.toString()
            val paswwordedtx= passwordedit.text.toString()


            if((TextUtils.isEmpty(emailedtx)) || (TextUtils.isEmpty(paswwordedtx))){
                Toast.makeText(requireActivity(), " Add username & Password", Toast.LENGTH_SHORT).show()

            }
            else{
                val checkuser = dbh.checkuserpass(emailedtx, paswwordedtx)
                if (checkuser==true){
                    Toast.makeText(requireActivity(), " Login succesfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, Home_fragment::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(requireActivity(), "Wrong username & password", Toast.LENGTH_SHORT).show()
                }
            }


        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}