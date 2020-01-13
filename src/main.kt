import java.util.*
fun main(args: Array<String>)
{
    var status: Boolean = true
    var numOfAttributes: Int

    val scan = Scanner(System.`in`)
    var menuChoice: String

    var query: Queries = Queries()
    query.openFile("/Users/Sarthak/Documents/IntelliJ/Kotlin-QuickQuery/resources/MaleFirstNames.Txt")
    query.readFile("MaleFirstNames.Txt")
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

        while(numOfAttributes>0)
        {
            print("Type in the name of attribute: " + (counter+1))
            val name:String = scan.nextLine() + " "
            print("Select data type for attribute: ${counter+1}\n1)Name \n2)Email \n3)Date \n4)Num")
            val dataType: Int = Integer.parseInt(scan.nextLine())
            namesOfAttributes[counter]  = name + dataType
            numOfAttributes--
            counter++

        }

        print("Enter the amount of randomly generated entities desired")
        val amtWanted: String = scan.nextLine()

        print("Press any key to create a table\n")
        menuChoice = scan.nextLine()
    } //val n = scan.nextLine().trim().toInt()
}