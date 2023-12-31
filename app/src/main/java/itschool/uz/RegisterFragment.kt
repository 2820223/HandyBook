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
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController

//
//// TODO: Rename parameter arguments, choose names that match
//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
//
//private lateinit var name:EditText
//private lateinit var surname:EditText
//private lateinit var email:EditText
//private lateinit var password:EditText
//private lateinit var registerBtn:EditText
//private lateinit var passwordcheck:EditText
//private lateinit var db: DBHelper

class RegisterFragment : Fragment() {


        private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_register, container, false)

            sharedPreferencesHelper = SharedPreferencesHelper(requireContext())

            view.findViewById<Button>(R.id.royhatdan_otish_btn).setOnClickListener {
                val email = view.findViewById<EditText>(R.id.email_reg_edittext).text.toString()
                val password = view.findViewById<EditText>(R.id.parol_reg_edittext).text.toString()

                // Save user details
                sharedPreferencesHelper.saveUserDetails(email, password)

                // Redirect to main page
                redirectToMainPage()
            }

            return view
        }

        private fun redirectToMainPage() {
            // Perform navigation to the main page here
            // For example, using Navigation Component:
            findNavController().navigate(R.id.action_registerFragment_to_home_fragment)
        }
    }


//    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//
//        name.findViewById<EditText>(R.id.name)
//        surname.findViewById<EditText>(R.id.surname)
//        email.findViewById<EditText>(R.id.email_reg_edittext)
//        password.findViewById<EditText>(R.id.parol_reg_edittext)
//        passwordcheck.findViewById<EditText>(R.id.parol_check_reg_edittext)
//        registerBtn.findViewById<Button>(R.id.royhatdan_otish_btn)
//        db = DBHelper(this.requireActivity())
//
//        registerBtn.setOnClickListener{
//            val nametext = name.text.toString()
//            val surnametext = surname.text.toString()
//            val emailtext = email.text.toString()
//            val passwordtext = password.text.toString()
//            val passwordchecktext = passwordcheck.text.toString()
//            val savedata = db.insertdata(emailtext,passwordtext)
//
//
//
//            if ((TextUtils.isEmpty(nametext) ) ||  TextUtils.isEmpty(surnametext) || (TextUtils.isEmpty(emailtext)) || (TextUtils.isEmpty(passwordchecktext) ) ||  (TextUtils.isEmpty(passwordtext)) )
//                {
//                Toast.makeText(requireActivity(), " Add name, surname, password, email and confirm password", Toast.LENGTH_SHORT).show()
//                }
//
//            else{
//                if (passwordtext.equals(passwordchecktext)) {
//                    if (savedata == true) {
//                        Toast.makeText(
//                            requireActivity(),
//                            "Registered succesfully",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        val intent = Intent(context, LoginFragment::class.java)
//                        startActivity(intent)
//
//                    } else {
//                        Toast.makeText(requireActivity(), "User exists", Toast.LENGTH_SHORT).show()
//                    }
//                }
//                else{
//                    Toast.makeText(requireActivity(), "Passwords don't match", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//        }
//
//
//
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        return inflater.inflate(R.layout.fragment_register, container, false)
//    }
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment RegisterFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            RegisterFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
