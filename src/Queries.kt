
import java.io.FileReader
import java.util.*

class Queries
{
    var names: ArrayList<String> = ArrayList()
    var emails: ArrayList<String> = ArrayList()
    var ranNames: ArrayList<String> = ArrayList()
    var ranEmails: ArrayList<String> = ArrayList()
    var ranDates: ArrayList<String> = ArrayList()
    var insertQueries: ArrayList<String> = ArrayList()
    lateinit var file:Scanner

    init
    {
        names = ArrayList()
        file = Scanner(FileReader("/Users/Sarthak/Documents/IntelliJ/Kotlin-QuickQuery/resources/MaleFirstNames.Txt"))
    }

    private fun openFile(name: String)
    {
        try{
            file = Scanner(FileReader(name))
            //print("Opened File")
        }
        catch(e: Exception)
        {
            print(e.printStackTrace())
        }
    }

    fun closeFile(){
        file.close()
    }
    private fun readFile(fileName: String)
    {
        while (file.hasNext())
        {
            var name: String = file.next()

            when (fileName)
            {
                "MaleFirstNames.Txt" ->
                {
                    if(name != " ")
                    names.add(name)
                    //print("Case hit")
                }
            }
        }
    }

    fun createTable(tableName: String, amtOfEntities: Int, attributeNames: Array<String?>): String
    {
        var myTableSkeleton: String = "Create table $tableName ("
        var myAttributes: Array<String?>
        var myEntities: ArrayList<String> = ArrayList()
        for((counter, x) in (0 until amtOfEntities).withIndex())
        {
            myAttributes = attributeNames[counter]?.split(" ")!!.toTypedArray()

            when(myAttributes[1])
            {
                "1" -> myEntities.add(myAttributes[0] + " varchar(55)")
                "2" -> myEntities.add(myAttributes[0] + " varchar(55)")
                "3" -> myEntities.add(myAttributes[0] + " date")
                "4" -> myEntities.add(myAttributes[0] + " int")
            }
        }

        myTableSkeleton+= myListIterator((myEntities))
        return myTableSkeleton
    }

    private fun myListIterator(entities: ArrayList<String>): String
    {
        var myIterator: Iterator<String> = entities.iterator()
        var myBuilder: StringBuilder = StringBuilder()
        var size: Int = entities.size
        for((counter) in entities.withIndex())
        {
            if(counter==(size-1))
            {
                myBuilder.append(entities[counter] + ");" )
                return myBuilder.toString()
            }
            else
            {
                myBuilder.append(entities[counter] + ", ")
            }
        }
        return myBuilder.toString()
    }

    fun generateQuery (attributes: Array<String?>, amtOfEnt: Int, tableName: String): ArrayList<String>
    {
        var att: Array<String>
        var ranName: String
        var counter: Int = 0
        var ran: Random = Random()
        var randNum: Int
        var amtEntered = amtOfEnt

        for(x in attributes)
        {
            att = attributes[counter]?.split(" ")!!.toTypedArray()

            for(x in 0..amtEntered )
            {
                when(att[1])
                {
                    "1" ->
                    {
                        openFile("/Users/Sarthak/Documents/IntelliJ/Kotlin-QuickQuery/resources/MaleFirstNames.Txt")
                        readFile("MaleFirstNames.Txt")
                        closeFile()
                        randNum = ran.nextInt(48)
                        ranName = names.get(randNum)
                        ranNames.add(ranName)

                        if(counter==attributes.size-1)
                        {
                            //todo block still needs to be implemented
                        }
                    }
                }
                counter++
            }
        }
        var toPass: String = requiredQuery(tableName, attributes)

        return linkDataQuery(toPass, attributes)
    }

    private fun linkDataQuery(toPassQuery: String, attributes: Array<String?>): ArrayList<String>
    {
        var j: Int = 0
        for((i) in (ranNames-1).withIndex())
        {
           var requiredQuery: StringBuilder = StringBuilder(toPassQuery)
           var insertSB2: StringBuilder = StringBuilder("VALUES (")
           var att: Array<String>
           var counter = 0
           for(x in attributes)
           {
               att = attributes[counter]?.split(" ")!!.toTypedArray()
               if(att[1] == "1")
               {
                   insertQueries.add(requiredQuery.append(insertSB2.append("\n"+"'"+ ranNames[i] + "'" + ");").toString()).toString())
               }
               else{
                   insertSB2.append("'" + ranNames[i] + "'" + " ,")
               }

               if(att[1] == "2")
               {
                   if(j==attributes.size-1)
                   {
                       insertQueries.add(requiredQuery.append(insertSB2.append("'"+ ranEmails[j] + "'" + ");").toString()).toString());
                   }
                   else
                   {
                       insertSB2.append("'" + ranEmails[i] + "'" + " ,");
                   }
               }

               if(att[1] == "3")
               {
                   if(j==attributes.size-1)
                   {
                       insertQueries.add(requiredQuery.append(insertSB2.append("'"+ ranDates[i] + "'" + ");").toString()).toString());
                   }
                   else
                   {
                       insertSB2.append("'" + ranDates[i] + "'" + " ,");
                   }
               }
           }
        }
        return insertQueries
    }

    private fun requiredQuery(tableName: String, attributes: Array<String?>): String
    {
        var insertSB1: StringBuilder = StringBuilder("INSERT INTO $tableName( ")
        var att: ArrayList<String>

        for((counter) in attributes.withIndex())
        {
            att = attributes[counter]?.split(" ") as ArrayList<String>

            if(counter==attributes.size-1)
            {
                insertSB1.append(att[0] + ")" + "\n");
            }
            else
            {
                insertSB1.append(att[0] + ", ");
            }
        }
        return insertSB1.toString()
    }
}
