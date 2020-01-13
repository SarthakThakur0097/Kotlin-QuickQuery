import java.io.FileReader
import java.util.*

class Queries
{
    lateinit var names: ArrayList<String>
    lateinit var emails: ArrayList<String>
    lateinit var ranNames: ArrayList<String>
    lateinit var ranEmails: ArrayList<String>
    lateinit var ranDates: ArrayList<String>
    lateinit var insertQueries: ArrayList<String>
    lateinit var file:Scanner

    init
    {
        names = ArrayList()
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

    fun closeFile(){
        file.close()
    }
    fun readFile(fileName: String)
    {
        while (file.hasNext())
        {
            var name: String = file.next()

            when (fileName)
            {
                "MaleFirstNames.Txt" ->
                {
                    names.add(name)
                    print("Case hit")
                }
            }
        }
    }
}
