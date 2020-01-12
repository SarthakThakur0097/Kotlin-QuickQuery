import java.io.FileReader
import java.util.*

class Queries
{
    lateinit var names: Array<String>
    lateinit var emails: Array<String>
    lateinit var ranNames: Array<String>
    lateinit var ranEmails: Array<String>
    lateinit var ranDates: Array<String>
    lateinit var insertQueries: Array<String>
    lateinit var file:Scanner

    init
    {

    }

    fun openFile(name: String)
    {
        try{
            file = Scanner(FileReader(name))
            print("Opened File")
        }
        catch(e: Exception)
        {
            print(e.printStackTrace())
        }
    }
}
