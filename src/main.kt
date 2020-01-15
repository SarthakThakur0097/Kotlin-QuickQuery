import java.util.*
fun main(args: Array<String>)
{
    val queries: Queries = Queries()

    var status: Boolean = true
    var numOfAttributes: Int = 0

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

        while(numOfAttributes<1) {
            try
            {
                print("Specify the amount of attributes desired in your table\n")
                numOfAttributes = scan.nextInt()
            } catch (e: InputMismatchException) {
                print("Please enter an integer value\n")
                scan.next()
            }
        }

        scan.nextLine()
        var namesOfAttributes = arrayOfNulls<String>(numOfAttributes)

        while(counter<numOfAttributes)
        {
            print("Type in the name of attribute: " + (counter+1)+"\n")
            val name:String = scan.nextLine() + " "
            var dataType: Int = 0

            while(dataType<1 || dataType>4)
            {
                try {
                    print("Select data type for attribute: ${counter + 1}\n1)Name \n2)Email \n3)Date \n4)Num\n")
                    dataType = Integer.parseInt(scan.nextLine())
                }
                catch(e: NumberFormatException)
                {
                    println("Please select a number from 1 to 4\n")
                }
            }
            namesOfAttributes[counter]  = name + dataType
            counter++
        }

        var amtWanted: Int? = null

        while(amtWanted==null || amtWanted<0) {
            try
            {
                print("Enter the amount of randomly generated entities desired\n")
                amtWanted = scan.nextInt()
            }
            catch(e: NumberFormatException)
            {
                print("Please enter an integer value \n")
                scan.next()
            }
            catch(e: InputMismatchException)
            {
                print("Please enter an integer value \n")
                scan.next()
            }
        }

        print(queries.createTable(tableName, numOfAttributes, namesOfAttributes))
        var myQueries: ArrayList<String> = queries.generateQuery(namesOfAttributes, amtWanted, tableName)
        println("Press any key to create a table\n")

        for(x in myQueries)
        {
            print(x + "\n\n")
        }
        menuChoice = scan.nextLine()
    } //val n = scan.nextLine().trim().toInt()
}