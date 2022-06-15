package icsdiscover.cwv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import icsdiscover.cwv.MainActivity.Companion.webView
import icsdiscover.cwv.databinding.FragmentWebBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WebFragment : Fragment() {

    private var _binding: FragmentWebBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_settings).isVisible = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentWebBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView = binding.webView

        // loading url in the the WebView.
        webView!!.loadUrl("https://ics-discovers-book-search.herokuapp.com")

        // this will enable the javascript.
        webView!!.settings.javaScriptEnabled = true
        webView!!.settings.domStorageEnabled = true
        webView!!.settings.loadsImagesAutomatically = true
        webView!!.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView!!.webViewClient = WebViewClient()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}