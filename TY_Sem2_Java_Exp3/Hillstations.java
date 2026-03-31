
class Mahabaleshwar extends Hillstations{
    void famousfor(){
        System.out.println("Mahabaleshwar is famous for cool climate and Venna Lake");
    }
    void famousfood(){
        System.out.println("Mahabaleshwar's famous food is strawberry with cream\n");
    }
}

class Matheran extends Hillstations{
    void famousfor(){
        System.out.println("Matheran is famous for horses");
    }
    void famousfood(){
        System.out.println("Matheran's famous food is Harbara (chhana)\n");
    }
}

class Panchgani extends Hillstations{
    void famousfor(){
        System.out.println("Panchgani is famous for Mapro");
    }
    void famousfood(){
        System.out.println("Panchgani's famous food is Mapro Sandwich\n");
    }
}


class Hillstations 
{
    void famousfor()
    {
        System.out.println("FamousFor Method from PARENT CLASS.");
    }

    void famousfood()
    {
        System.out.println("FamousFood Method from PARENT CLASS.\n");
    }
    public static void main(String args[]){
        Hillstations hill = new Hillstations();
        hill.famousfor();
        hill.famousfood();

        Mahabaleshwar maha = new Mahabaleshwar();
        maha.famousfor();
        maha.famousfood();

        Matheran math = new Matheran();
        math.famousfor();
        math.famousfood();

        Panchgani panch = new Panchgani();
        panch.famousfor();
        panch.famousfood();
    }
}

//shows overRIDE since the parameters (blank) are same for all the 3 subclasses yet they are accessed only by their objects so contexxct remains safee