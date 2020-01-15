import java.util.*
fun main(args: Array<String>)
{
    val queries: Queries = Queries()

    var status: Boolean = true
    var numOfAttributes: Int

    val scan = Scanner(System.`in`)
    var menuChoice: String

    var query: Queries = Queries()
//    query.openFile("/Users/Sarthak/Documents/IntelliJ/Kotlin-QuickQuery/resources/MaleFirstNames.Txt")
//    query.readFile("MaleFirstNames.Txt")
    query.closeFile()
    print("Press any key to create a table\n")
    menuChoice = scan.nextLine()

    while(status)
    {
        var counter: Int = 0
        print("Enter the name you would like to give to your table\n")
        val tableName: String = scan.nextLine() + " "

        print("Specify the amount of attributes desired in your table\n")
        numOfAttributes = scan.nextInt()

        scan.nextLine()
        var namesOfAttributes = arrayOfNulls<String>(numOfAttributes)

        while(counter<numOfAttributes)
        {
            print("Type in the name of attribute: " + (counter+1))
            val name:String = scan.nextLine() + " "
            print("Select data type for attribute: ${counter+1}\n1)Name \n2)Email \n3)Date \n4)Num")
            val dataType: Int = Integer.parseInt(scan.nextLine())
            namesOfAttributes[counter]  = name + dataType

            counter++

        }

        print("Enter the amount of randomly generated entities desired")
        val amtWanted: String = scan.nextLine()

        print(queries.createTable(tableName, numOfAttributes, namesOfAttributes))
        var myQueries: ArrayList<String> = queries.generateQuery(namesOfAttributes, amtWanted, tableName)
        println("Press any key to create a table\n")

        for(x in myQueries)
        {
            print(x + "\n")
        }
        menuChoice = scan.nextLine()


    } //val n = scan.nextLine().trim().toInt()
}