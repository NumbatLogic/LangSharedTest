<?php
	include_once dirname(__FILE__) . "/../../ProjectGen/ProjectGen.php";
	include_once dirname(__FILE__) . "/../../LangShared/LangShared.php";
	include_once dirname(__FILE__) . "/LangSharedTest/LangSharedTest.php";

	class LangSharedTest_Solution_Config extends Solution_Config
	{
		public function __construct($sAction)
		{
			parent::__construct($sAction);
			$this->m_pProjectArray[] = new LangShared_Config($sAction, dirname(__FILE__) . "/LangShared.package-list");
			$this->m_pProjectArray[] = new LangSharedTest_Config($sAction);
		}

		public function GetName() { return "LangSharedTest"; }
	}

	ProjectGen(new LangSharedTest_Solution_Config(ProjectGen_GetAction()));
?>
